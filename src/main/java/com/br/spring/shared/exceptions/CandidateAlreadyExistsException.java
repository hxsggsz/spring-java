package com.br.spring.shared.exceptions;

public class CandidateAlreadyExistsException  extends RuntimeException {
    public CandidateAlreadyExistsException() {
        super("This candidate already exists");
    }
}
