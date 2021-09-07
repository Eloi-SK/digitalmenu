package com.eloi.digitalmenu.infrastructure.services;

import com.eloi.digitalmenu.domain.models.User;
import com.eloi.digitalmenu.domain.repositories.UserRepository;
import com.eloi.digitalmenu.domain.services.AuthService;
import com.eloi.digitalmenu.security.jwt.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
	AuthenticationManager authenticationManager;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder encoder;

    @Autowired
	JwtUtils jwtUtils;
    
    @Override
    public String register(String username, String email, String password) {
        if (userRepository.existsByUsername(username)) {
            return "Erro: Nome de usuário já existe";
        }

        if (userRepository.existsByEmail(email)) {
            return "Erro: Email já está em uso";
        }

        User user = new User(username, email, encoder.encode(password));

        userRepository.save(user);

        return null;
    }

    @Override
    public String login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(username, password));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        return jwt;
    }
    
}
