package ru.netology.dao.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(authorizeHttpRequests -> authorizeHttpRequests
                .anyRequest()
                .authenticated());
        http.headers(Customizer.withDefaults());
        http.sessionManagement(Customizer.withDefaults());
        http.formLogin(Customizer.withDefaults());
        http.anonymous(Customizer.withDefaults());
        http.csrf(Customizer.withDefaults());
        return http.build();
    }

    // Добавьте несколько пользователей с разными набором ролей: "READ", "WRITE", "DELETE"
    @Bean
    public UserDetailsService inMemoryUserDetailsService(PasswordEncoder passwordEncoder) {
        User.UserBuilder users = User.builder()
                .passwordEncoder(passwordEncoder::encode);
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(users.username("user1")
                .password("pass")
                .roles("READ")
                .build());
        userDetailsManager.createUser(users.username("user2")
                .password("pass")
                .roles("READ", "WRITE")
                .build());
        userDetailsManager.createUser(users.username("user3")
                .password("pass")
                .roles("READ", "WRITE", "DELETE")
                .build());
        userDetailsManager.createUser(users.username("vladimir")
                .password("pass")
                .roles("READ")
                .build());
        return userDetailsManager;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
