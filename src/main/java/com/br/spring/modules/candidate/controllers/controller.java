package com.br.spring.modules.candidate.controllers;


import com.br.spring.modules.candidate.entities.CandidateEntity;
import com.br.spring.modules.candidate.useCases.CreateCandidateUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidates")
public class controller {
    @Autowired
    CreateCandidateUseCase createCandidateUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidate) {
        try {
        var result = this.createCandidateUseCase.execute(candidate);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


}