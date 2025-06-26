package com.example.demo.services.impl;

import com.example.demo.DTO.RegisterRequest;
import com.example.demo.entity.Credentials;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.repositories.CredentialsRepository;
import com.example.demo.repositories.RoleRepository;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final CredentialsRepository credentialsRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void register(RegisterRequest registerRequest) {
        User user = new User();
        user.setName(registerRequest.name());
        user.setAge(registerRequest.age());

        Credentials credential = new Credentials();
        credential.setUsername(registerRequest.name());
        credential.setPassword(passwordEncoder.encode(registerRequest.password()));
        credential.setRole(new Role().builder().name("ROLE_USER").build());
        credential.setUser(user);
        userRepository.save(user);
        credentialsRepository.save(credential);
    }

}
