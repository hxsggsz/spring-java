package com.br.spring.modules.job.controllers;

import com.br.spring.modules.company.dtos.CreateCompanyDTO;
import com.br.spring.modules.company.useCases.CreateCompanyUseCase;
import com.br.spring.modules.job.dtos.CreateJobDTO;
import com.br.spring.modules.job.useCases.CreateJobUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class JobController {
    @Autowired
    CreateJobUseCase createCompanyUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> createCompany(@Valid @RequestBody CreateJobDTO job) {
        try {
            var result = this.createCompanyUseCase.execute(job);
            return ResponseEntity.status(HttpStatus.CREATED).body(result);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
