package com.example.demo.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record HobbyDTO(
        @NotNull
                @Min(2)
                @Max(50)
        String type

        ) {
}
