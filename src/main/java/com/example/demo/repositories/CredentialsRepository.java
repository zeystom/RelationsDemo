package com.example.demo.repositories;
import java.util.Optional;

import com.example.demo.entity.Credentials;
import com.example.demo.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CredentialsRepository extends JpaRepository<Credentials,Long> {
    Optional<Credentials> findByUserName(String name);
}
