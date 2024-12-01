package com.backend.ecommerce.infrastructure.entrypoints.api.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/api")
public class HealthController {


    @GetMapping("/hello")
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public Mono<String> hello() {
        return Mono.just("Hello World!");
    }

    @GetMapping("/bay")
    @PreAuthorize("hasAuthority('SCOPE_CLIENT')")
    public Mono<String> bay() {
        return Mono.just("Bay World!");
    }

}
