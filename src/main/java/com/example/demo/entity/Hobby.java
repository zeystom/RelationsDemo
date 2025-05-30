package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Data
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(schema = "users_schema", name = "t_hobbies")
public class Hobby {
    @Id
    Long id;

    @Column(name = "c_type")
    String type;

    @ManyToMany(mappedBy = "hobbies")
    Set<User> users;
}
