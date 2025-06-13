package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "users_schema", name = "t_passports")
@Builder
public class Passport {
    @Id
    Long id;

    @Column(name = "c_number")
    String number;

}
