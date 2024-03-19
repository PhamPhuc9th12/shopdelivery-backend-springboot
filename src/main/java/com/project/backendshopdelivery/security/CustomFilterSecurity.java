package com.project.backendshopdelivery.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class CustomFilterSecurity  {
    private final CustomUserDetailService customUserDetailService;
    private final CustomJwtTokenFilter customJwtTokenFilter;

    @Bean
    public AuthenticationManager authenticationManager(
            HttpSecurity httpSecurity) throws Exception {
        AuthenticationManagerBuilder authenticationManagerBuilder =
                httpSecurity.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(customUserDetailService).passwordEncoder(passwordEncoder());
        return authenticationManagerBuilder.build();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.cors().disable()// disable cors
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .csrf().disable() // loi k can chung thuc
                .authorizeHttpRequests()
//               .antMatchers("/api/v1/user/**").permitAll(); // cho phép truy caapj k can xac tực
                .antMatchers("/api/v1/auth/**","/api/v1/upload/res/file/**","/swagger-ui/**").permitAll()
                .anyRequest().authenticated();// yeu cau cac request con lai phai chung thuc
//                .and().httpBasic(); // Basic Authentication
        http.addFilterBefore(customJwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
