package com.backend.ecommerce.infrastructure.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
// @EnableReactiveMethodSecurity
public class SecurityConfig {
    
	@Order(Ordered.HIGHEST_PRECEDENCE)
	@Bean
	public SecurityWebFilterChain securityFilterChain(ServerHttpSecurity http) {
		http
		.cors(cors -> cors.disable())
				.csrf(ServerHttpSecurity.CsrfSpec::disable)
				.formLogin(ServerHttpSecurity.FormLoginSpec::disable)
				.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
				.authorizeExchange(exchanges -> exchanges
						.pathMatchers("/**")
						.permitAll()
						.anyExchange()
						.authenticated())
				.oauth2ResourceServer(oauth2 -> oauth2
						.jwt(Customizer.withDefaults()));;

		return http.build();
	}

	// @Bean
	// SecurityWebFilterChain webHttpSecurity(ServerHttpSecurity http) {
	// 	http
	// 			.cors(cors -> cors.disable())
	// 			.formLogin(ServerHttpSecurity.FormLoginSpec::disable)
	// 			.httpBasic(ServerHttpSecurity.HttpBasicSpec::disable)
	// 			.authorizeExchange(exchanges -> exchanges.anyExchange().permitAll())
	// 			.oauth2ResourceServer(oauth2 -> oauth2
	// 					.jwt(Customizer.withDefaults()));

	// 	return http.build();
	// }


}
