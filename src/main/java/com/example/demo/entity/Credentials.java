package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.example.demo.entity.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(schema = "users_schema", name = "t_credentials")
public class Credentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(nullable = false, name = "c_username")
    String username;

    @Column(nullable = false, name = "c_password")
    String password;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "c_role_id")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "c_user_id", referencedColumnName = "id")
    User user;

}
