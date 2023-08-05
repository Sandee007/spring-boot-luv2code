package com.sandee007.mvcSecurity.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails john = User.builder()
                               .username("john")
                               .password("{noop}123") // noop => no operation on password / not encrypted
                               .roles(Role.EMPLOYEE.name())
                               .build();

        UserDetails mary = User.builder()
                               .username("mary")
                               .password("{noop}123")
                               .roles(Role.EMPLOYEE.name(), Role.MANAGER.name())
                               .build();

        UserDetails susan = User.builder()
                                .username("susan")
                                .password("{noop}123")
                                .roles(Role.EMPLOYEE.name(), Role.MANAGER.name(), Role.ADMIN.name())
                                .build();

        return new InMemoryUserDetailsManager(john, mary, susan);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeHttpRequests(config ->
                        config
                                .requestMatchers("/css/**", "anotherUrl").permitAll()
                                .requestMatchers("/leaders/**").hasRole(Role.MANAGER.name())
                                .requestMatchers("/systems/**").hasRole(Role.ADMIN.name())
                                .anyRequest().authenticated()
                )
                .formLogin(loginForm ->
                        loginForm
                                .loginPage("/login")
                                // * spring will handle a POST request for this automatically, must have name,password
                                .loginProcessingUrl("/handle-login")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll())
                .exceptionHandling(config ->
                        config
                                .accessDeniedPage("/access-denied")
                );

        return httpSecurity.build();
    }
}
