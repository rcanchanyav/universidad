package com.prueba.notas;

import com.prueba.notas.config.JWTAuthorizationFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SpringBootApplication
public class NotasApplication {

    public static void main(String[] args) {
        SpringApplication.run(NotasApplication.class, args);
    }

    @EnableWebSecurity
    @Configuration
    static
    class SpringSecurityConfiguration {

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .addFilterAfter(new JWTAuthorizationFilter(),
                            UsernamePasswordAuthenticationFilter.class)
                    .authorizeRequests().antMatchers("/h2/**").permitAll()
                    .antMatchers(HttpMethod.POST, "/user").permitAll()
                    .anyRequest().authenticated();
            http.headers().frameOptions().disable();
            return http.build();
        }
    }
}
