package com.courses.ocourses.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public UserDetailsService users(PasswordEncoder passwordEncoder){
//        UserDetails user = User.builder()
//                .username("vitor")
//                .password(passwordEncoder.encode("12"))
//                .roles("ADMIN")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }


    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http){
        http.authorizeHttpRequests(request ->
                        request.requestMatchers("/h2-console/**").permitAll()
                                .anyRequest().authenticated())
                .formLogin(form -> form.permitAll())
                .logout(LogoutConfigurer::permitAll)
                .csrf( csrf -> csrf.disable()
                        .headers(headers -> headers.frameOptions(frame -> frame.disable())));
        return http.build();
    }


}
