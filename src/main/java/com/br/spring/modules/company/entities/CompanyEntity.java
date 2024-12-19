package com.br.spring.modules.company.entities;

import com.br.spring.modules.candidate.dto.CreateCandidateDTO;
import com.br.spring.modules.company.dtos.CreateCompanyDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "company")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String username;

    @Email(message = "email not valid")
    private String email;

    @Length(min = 8, max = 255, message = "password not valid")
    private String password;

    @Length(min = 8, max = 255, message = "description not valid")
    private String description;

    @URL(message = "website should be a valid url")
    private String website;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public CompanyEntity(CreateCompanyDTO company) {
        BeanUtils.copyProperties(company, this);
    }

    public CompanyEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public @URL(message = "website should be a valid url") String getWebsite() {
        return website;
    }

    public void setWebsite(@URL(message = "website should be a valid url") String website) {
        this.website = website;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
