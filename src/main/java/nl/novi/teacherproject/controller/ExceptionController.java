package nl.novi.teacherproject.controller;

import nl.novi.teacherproject.exception.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<String> handleRecordNotFound(RecordNotFoundException exception){
        //als teacher niet gevonden wordt, komt de RecordNotFound message via de Exception controller, met de methode + message uit de servicelaag tevoorschijn
        return new ResponseEntity(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
