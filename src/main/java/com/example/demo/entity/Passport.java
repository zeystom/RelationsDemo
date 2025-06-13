package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "users_schema", name = "t_passports")
@Builder
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    Long id;

    @Column(name = "c_number")
    String number;

}
