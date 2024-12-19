package com.br.spring.shared.exceptions;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException() {
        super("This user already exists");
    }
}
