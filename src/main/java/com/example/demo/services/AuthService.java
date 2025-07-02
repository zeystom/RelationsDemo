package com.example.demo.services;

import com.example.demo.DTO.JwtResponse;
import com.example.demo.DTO.LoginRequest;
import com.example.demo.DTO.RefreshRequest;
import com.example.demo.DTO.RegisterRequest;

public interface AuthService {
     void register(RegisterRequest registerRequest);
     JwtResponse login(LoginRequest request);
     JwtResponse refreshToken(RefreshRequest request);
}
