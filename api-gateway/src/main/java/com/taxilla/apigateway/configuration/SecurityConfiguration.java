package com.taxilla.apigateway.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.web.server.csrf.ServerCsrfTokenRepository;

@Configuration
public class SecurityConfiguration {

    @Bean
    SecurityWebFilterChain authorization(ServerHttpSecurity http) {
        return http //
                .httpBasic(c -> Customizer.withDefaults()) //
                .csrf(ServerHttpSecurity.CsrfSpec::disable) //
//                .csrf().csrfTokenRepository((ServerCsrfTokenRepository) csrfTokenRepository())
//                .and()
                .authorizeExchange()
                        .pathMatchers("/rl").authenticated() // <1>
                        .anyExchange().permitAll()
                .and()//
                .build();
    }

    private CsrfTokenRepository csrfTokenRepository()
    {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setSessionAttributeName("_csrf");
        return repository;
    }
//
//    @Bean
//    MapReactiveUserDetailsService authentication() {
//        return new MapReactiveUserDetailsService(User.withDefaultPasswordEncoder()
//                .username("jlong").password("pw").roles("USER").build());
//    }
}
