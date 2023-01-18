package com.rafaelbp.TrelloClone.controllers.advice;

import com.rafaelbp.TrelloClone.exceptions.ListNotFoundException;
import com.rafaelbp.TrelloClone.exceptions.TaskNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<?> handeNonUserFoundException(TaskNotFoundException e) {
        var error = new HashMap<String, String>();
        error.put("message", e.getMessage());
        error.put("status", "400");
        error.put("time", "1300");

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ListNotFoundException.class)
    public ResponseEntity<String> handleListNotFoundException(ListNotFoundException e) {
        return new ResponseEntity<>("List not found", HttpStatus.BAD_REQUEST);
    }
}
