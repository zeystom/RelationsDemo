package com.example.demo.DTO;

import com.example.demo.entity.Account;
import com.example.demo.entity.Hobby;
import com.example.demo.entity.Passport;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Set;
import java.util.List;

public record UserDTO (
        @NotNull
        @Size(min = 1, max = 50)
        String name,
        @Min(0)
        @Max(150)
        int age,
        @NotNull
        Passport passport,
        List<Account> accounts,
        Set<Hobby> hobbies
){}
