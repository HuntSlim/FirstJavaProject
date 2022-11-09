package guru.springframework.spring5webapp.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class BookExeptionController {
    @ExceptionHandler(value = BookNotFoundExeption.class)
    public ResponseEntity<Object> exception(BookNotFoundExeption exception){
        return new ResponseEntity<>("Book Not Found", HttpStatus.NOT_FOUND);
    }
}
