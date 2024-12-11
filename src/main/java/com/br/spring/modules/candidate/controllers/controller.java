package com.br.spring.modules.candidate.controllers;


import com.br.spring.modules.candidate.entities.CandidateEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidates")
public class controller {
    @PostMapping("/")
    public String create(@RequestBody CandidateEntity candidate) {
        return "novo candidato com o nome: " + candidate.getName();
    }
}
