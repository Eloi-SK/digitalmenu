package com.eloi.digitalmenu.domain.services;

public interface AuthService {
    String register(String username, String email, String password);
    String login(String username, String password);
}
