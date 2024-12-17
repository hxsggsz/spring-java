package com.br.spring.modules.candidate.dto;

import com.br.spring.modules.candidate.entities.CandidateEntity;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

public class CreateCandidateDTO {

    private String name;
    private String username;
    @Email(message = "email not valid")
    private String email;
    @Length(min = 8, max = 255, message = "password not valid")
    private String password;
    @Length(min = 8, max = 255, message = "description not valid")
    private String description;

    public CreateCandidateDTO(CandidateEntity candidate) {
        BeanUtils.copyProperties(candidate, this);
    }

    public CreateCandidateDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public @Email(message = "email not valid") String getEmail() {
        return email;
    }

    public void setEmail(@Email(message = "email not valid") String email) {
        this.email = email;
    }

    public @Length(min = 8, max = 255, message = "password not valid") String getPassword() {
        return password;
    }

    public void setPassword(@Length(min = 8, max = 255, message = "password not valid") String password) {
        this.password = password;
    }

    public @Length(min = 8, max = 255, message = "description not valid") String getDescription() {
        return description;
    }

    public void setDescription(@Length(min = 8, max = 255, message = "description not valid") String description) {
        this.description = description;
    }
}
