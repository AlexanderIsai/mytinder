package de.telran.mytinder.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionCatcher {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(){
        log.error("exception is handled");
        return new ResponseEntity<>("Something went false", HttpStatus.CONFLICT);
    }
}
