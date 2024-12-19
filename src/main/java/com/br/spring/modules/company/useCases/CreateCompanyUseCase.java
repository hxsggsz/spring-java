package com.br.spring.modules.company.useCases;

import com.br.spring.modules.company.dtos.CreateCompanyDTO;
import com.br.spring.modules.company.entities.CompanyEntity;
import com.br.spring.modules.company.repositories.CompanyRepository;
import com.br.spring.shared.exceptions.UserAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCompanyUseCase {

    @Autowired
    CompanyRepository companyRepository;

    public CompanyEntity execute(CreateCompanyDTO company) {

        this.companyRepository.findByUsernameOrEmail(company.getUsername(), company.getEmail())
                .ifPresent(cand -> {
                    throw new UserAlreadyExistsException();
                });

        var newCompany = new CompanyEntity(company);
        System.out.println(company);

        return companyRepository.save(newCompany);
    }
}
