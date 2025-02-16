package com.patrykharanczyk.resolutions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@SpringBootApplication
public class ResolutionsApplication {

    @Bean
    UserDetailsService userDetailsService(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain authenticationManager(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(a -> a
                .requestMatchers(HttpMethod.GET, "/resolutions", "/resolution/**").hasAnyAuthority("READ")
                .anyRequest().hasAuthority("WRITE")
        ).httpBasic(Customizer.withDefaults());

        return http.build();
    }

    public static void main(String[] args) {
        SpringApplication.run(ResolutionsApplication.class, args);
    }

}
