package com.br.spring.shared.exceptions;

import com.br.spring.shared.dtos.ErrorMessageDTO;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;

@ControllerAdvice
public class GlobalExceptionHandler {
    private MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource message) {
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ArrayList<Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        ArrayList<Object> dto = new ArrayList<>();

        e.getBindingResult().getFieldErrors().forEach(err -> {
            String message = messageSource.getMessage(err, LocaleContextHolder.getLocale());
            String field = err.getField();

            var error = new ErrorMessageDTO(message, field);
            dto.add(error);
        });

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }}