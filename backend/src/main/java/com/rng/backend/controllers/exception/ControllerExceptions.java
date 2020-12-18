package com.rng.backend.controllers.exception;

import com.rng.backend.service.exceptions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptions {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<FieldMessage> notFoundException(){
        FieldMessage fieldMessage = new FieldMessage(HttpStatus.NOT_FOUND.value(), "Object not found");

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(fieldMessage);
    }
}