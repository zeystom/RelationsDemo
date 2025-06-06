package com.example.demo.repositories;

import com.example.demo.entity.Hobby;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
    Optional<Hobby> findByName(String name);
}
