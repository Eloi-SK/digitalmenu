package com.eloi.digitalmenu.controllers;

import com.eloi.digitalmenu.domain.models.payloads.request.SignupRequest;
import com.eloi.digitalmenu.domain.models.payloads.response.MessageResponse;
import com.eloi.digitalmenu.domain.services.AuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("register")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) {
        String result = authService.register(
            signupRequest.getUsername(),
            signupRequest.getEmail(),
            signupRequest.getPassword());

        if (result != null) {
            ResponseEntity.badRequest().body(new MessageResponse(result));
        }
        
        return ResponseEntity.ok(new MessageResponse("Usuário registrado com sucesso."));
    }
}
