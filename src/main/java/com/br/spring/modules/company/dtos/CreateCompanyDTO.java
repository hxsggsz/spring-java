package com.br.spring.modules.company.dtos;

import com.br.spring.modules.candidate.entities.CandidateEntity;
import com.br.spring.modules.company.entities.CompanyEntity;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;
import org.springframework.beans.BeanUtils;

public class CreateCompanyDTO {
    private String username;

    @Email(message = "email not valid")
    private String email;

    @Length(min = 8, max = 255, message = "password not valid")
    private String password;

    @Length(min = 8, max = 255, message = "description not valid")
    private String description;

    @URL(message = "website should be a valid url")
    private String website;

    public CreateCompanyDTO(CompanyEntity company) {
        BeanUtils.copyProperties(company, this);
    }

    public CreateCompanyDTO() {

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
}
