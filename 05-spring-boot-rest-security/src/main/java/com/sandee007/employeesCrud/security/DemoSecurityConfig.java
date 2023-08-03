package com.sandee007.employeesCrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class DemoSecurityConfig {
    private final String EMPLOYEE = "EMPLOYEE";
    private final String MANAGER = "MANAGER";
    private final String ADMIN = "ADMIN";

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

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(config ->
                config
                        .requestMatchers(HttpMethod.GET, "/api/employees").hasAnyRole(EMPLOYEE, MANAGER, ADMIN)
                        .requestMatchers(HttpMethod.GET, "/api/employees/**").hasAnyRole(EMPLOYEE, MANAGER, ADMIN)
                        .requestMatchers(HttpMethod.POST, "/api/employees").hasAnyRole(MANAGER)
                        .requestMatchers(HttpMethod.PUT, "/api/employees").hasAnyRole(MANAGER)
                        .requestMatchers(HttpMethod.DELETE, "/api/employees").hasAnyRole(ADMIN)
        );

//        use HTTP basic authentication
        http.httpBasic(Customizer.withDefaults());

//disable CSRF
        http.csrf((csrf) -> csrf.disable());

        return http.build();
    }
}
