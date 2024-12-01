package com.backend.ecommerce.infrastructure.entrypoints.api.controllers.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.backend.ecommerce.application.repos.auth.IAuthRepo;
import com.backend.ecommerce.domain.ports.in.auth.dtos.LoginDTO;
import com.backend.ecommerce.domain.ports.in.auth.dtos.SaveUserDTO;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final IAuthRepo iAuthRepo;
    
    public AuthController(IAuthRepo iAuthRepo) {
        this.iAuthRepo = iAuthRepo;
    }
    @PostMapping("/login")
    public String token(@RequestBody LoginDTO loginDTO) throws Exception {
        return iAuthRepo.login(loginDTO);
    }
    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody SaveUserDTO user) throws Exception {
        iAuthRepo.register(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @GetMapping("/health")
    public String ok() throws Exception {
        return "ok";
    }
}
