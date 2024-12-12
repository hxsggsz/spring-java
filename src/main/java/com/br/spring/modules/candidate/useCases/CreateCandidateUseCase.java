package com.br.spring.modules.candidate.useCases;

import com.br.spring.modules.candidate.entities.CandidateEntity;
import com.br.spring.modules.candidate.repositories.CandidateRepository;
import com.br.spring.shared.exceptions.CandidateAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCandidateUseCase {
    @Autowired
    CandidateRepository candidateRepository;

    public CandidateEntity execute(CandidateEntity candidate) {

        this.candidateRepository.findByUsernameOrEmail(candidate.getUsername(), candidate.getEmail()).ifPresent(cand -> {
            throw new CandidateAlreadyExistsException();
        });
        return candidateRepository.save(candidate);
    }
}
