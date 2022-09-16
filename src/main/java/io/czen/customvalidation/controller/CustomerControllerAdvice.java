package io.czen.customvalidation.controller;

import io.czen.customvalidation.model.Error.ErrorBuilder;
import io.czen.customvalidation.model.Error.Errors;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class CustomerControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(value = BAD_REQUEST)
    @ResponseBody
    public Errors handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ErrorBuilder.buildMethodArgumentNotValidErrors(e);
    }
}
