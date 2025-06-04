package com.example.attendance.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration @EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/workers/**").hasRole("SUPERVISOR")
                .requestMatchers("/api/attendance/mark").hasRole("WORKER")
                .requestMatchers("/api/attendance/**").hasRole("SUPERVISOR")
                .anyRequest().authenticated()
            )
            .formLogin().and()
            .httpBasic();
        http.csrf().disable();
        return http.build();
    }
    @Bean
    public InMemoryUserDetailsManager userDetailsManager() {
        UserDetails worker = User.withDefaultPasswordEncoder()
            .username("worker")
            .password("password")
            .roles("WORKER")
            .build();
        UserDetails supervisor = User.withDefaultPasswordEncoder()
            .username("supervisor")
            .password("password")
            .roles("SUPERVISOR")
            .build();
        return new InMemoryUserDetailsManager(worker, supervisor);
    }
}
