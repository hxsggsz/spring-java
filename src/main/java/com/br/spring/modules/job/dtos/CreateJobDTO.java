package com.br.spring.modules.job.dtos;

import com.br.spring.modules.company.entities.CompanyEntity;
import com.br.spring.modules.job.entities.JobEntity;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import java.util.UUID;

public class CreateJobDTO {
    private String name;
    private String benefits;
    private String level;
    private UUID companyId;

    public CreateJobDTO(JobEntity job) {
        BeanUtils.copyProperties(job, this);
    }

    public CreateJobDTO() {
    }

    @Length(min = 8, max = 255, message = "description not valid")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBenefits() {
        return benefits;
    }

    public void setBenefits(String benefits) {
        this.benefits = benefits;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public UUID getCompanyId() {
        return companyId;
    }

    public void setCompanyId(UUID companyId) {
        this.companyId = companyId;
    }

    public @Length(min = 8, max = 255, message = "description not valid") String getDescription() {
        return description;
    }

    public void setDescription(@Length(min = 8, max = 255, message = "description not valid") String description) {
        this.description = description;
    }
}
