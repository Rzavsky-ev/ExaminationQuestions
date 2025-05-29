package pro.sky.coursework2.examinerservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pro.sky.coursework2.exceptions.MethodNotAllowedException;

@ControllerAdvice
public class QuestionControllerAdvice {
    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<String> methodNotAllowed(MethodNotAllowedException e) {
        String message = e.getMessage();
        return new ResponseEntity<>(message,HttpStatus.METHOD_NOT_ALLOWED);
    }

}



