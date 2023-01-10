package com.fitness.api.controllerImp;


import com.fitness.api.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<ResponseDto> handleEntityNotFoundException(EntityNotFoundException notFoundException){

        ResponseDto response = new ResponseDto();
        if (notFoundException.getMessage()!=null) response.setMessage(notFoundException.getMessage());
        else response.setMessage("Not found entity");
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
