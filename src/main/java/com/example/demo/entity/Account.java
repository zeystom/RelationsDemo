package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(schema = "users_schema", name = "t_account")
public class Account {
    @Id
    Long id;

    @Column(name = "c_title")
    String title;

    @ManyToOne
    @JoinColumn(name = "c_users_id")
    User user;
}
