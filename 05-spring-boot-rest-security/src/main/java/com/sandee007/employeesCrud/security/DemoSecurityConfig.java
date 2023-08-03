package com.sandee007.employeesCrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class DemoSecurityConfig {
    /*
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}123") // noop => no operation on password / not encrypted
                .roles(EMPLOYEE)
                .build();

        UserDetails mary = User.builder()
                .username("mary")
                .password("{noop}123")
                .roles(EMPLOYEE, MANAGER)
                .build();

        UserDetails susan = User.builder()
                .username("susan")
                .password("{noop}123")
                .roles(EMPLOYEE, MANAGER, ADMIN)
                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }
*/

    //    add support for jdbc users table for security
    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        /*
         * when using jdbc security authorities.authority must be prefixed with ROLE_
         * eg : -
         *   in db authorities.authority => ROLE_MANAGER
         *   in code user role string => MANAGER
         *   (spring will handle ROLE_ automatically)
         * */
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config ->
                config
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole(
                                Authorities.EMPLOYEE.name(),
                                Authorities.MANAGER.name(),
                                Authorities.ADMIN.name()
                        )
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole(
                                Authorities.EMPLOYEE.name(),
                                Authorities.MANAGER.name(), Authorities.ADMIN.name()
                        )
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasRole(Authorities.MANAGER.name())
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasRole(Authorities.MANAGER.name())
                        .requestMatchers(HttpMethod.DELETE, "/api/employees").hasRole(Authorities.ADMIN.name())
        );

//        use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

//disable CSRF
        http.csrf((csrf) -> csrf.disable());

        return http.build();
    }
}
