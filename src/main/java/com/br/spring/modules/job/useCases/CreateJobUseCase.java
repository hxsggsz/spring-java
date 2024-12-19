package com.br.spring.modules.job.useCases;

import com.br.spring.modules.job.dtos.CreateJobDTO;
import com.br.spring.modules.job.entities.JobEntity;
import com.br.spring.modules.job.repositories.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateJobUseCase {
    @Autowired
    private JobRepository jobRepository;

    public JobEntity execute(CreateJobDTO job) {
        var newCandidate = new JobEntity(job);
        return jobRepository.save(newCandidate);
    }
}
