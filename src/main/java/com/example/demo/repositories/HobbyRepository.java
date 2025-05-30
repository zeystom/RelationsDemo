package com.example.demo.repositories;

import com.example.demo.entity.Hobby;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface HobbyRepository extends JpaRepository<Hobby, Long> {
}
