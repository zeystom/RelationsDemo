package com.example.demo.controllers;

import com.example.demo.DTO.PassportDTO;
import com.example.demo.entity.Passport;
import com.example.demo.services.PassportService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/passport")
public class PassportController {
    private final PassportService passportService;

    @GetMapping
    public ResponseEntity<List<PassportDTO>> getPassports() {

        return ResponseEntity.ok().body(passportService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassportDTO> getPassportById(@PathVariable Long id) {
        return ResponseEntity.ok().body(passportService.findById(id));
    }

    @PostMapping
    public ResponseEntity<PassportDTO> createPassport(@RequestBody PassportDTO passportDTO){
        return ResponseEntity.ok().body(passportService.create(passportDTO) );
    }
    @PutMapping("/{id}")
    public ResponseEntity<PassportDTO > updatePassport(@PathVariable Long id, @RequestBody PassportDTO passportDTO){
        return ResponseEntity.ok().body(passportService.update(id, passportDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PassportDTO> deletePassport(@PathVariable Long id){
        passportService.delete(id);
        return ResponseEntity.noContent().build();
    }
}


