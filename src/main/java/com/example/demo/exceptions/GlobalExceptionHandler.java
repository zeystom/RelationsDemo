package com.example.demo.exceptions;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @Operation(summary = "Handles validation errors", description = "Returns field-level validation errors")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request - Validation failed",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Map.class),
                            examples = @ExampleObject(
                                    value = "{\"username\": \"Username must not be empty\", \"email\": \"Email must be valid\"}"
                            )
                    )
            )
    })
    public ResponseEntity<Map<String, String>> handleValidationErrors(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(NoSuchElementException.class)
    @Operation(summary = "Handles not found errors", description = "Returns a 404 when a resource is missing")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found - Resource does not exist",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = Map.class),
                            examples = @ExampleObject(value = "{\"message\": \"User not found\"}")
                    )
            )
    })
    public ResponseEntity<Map<String, String>> handleNotFoundErrors(NoSuchElementException ex) {
        Map<String, String> errors = Map.of("message", ex.getMessage());
        return ResponseEntity.status(404).body(errors);
    }
}