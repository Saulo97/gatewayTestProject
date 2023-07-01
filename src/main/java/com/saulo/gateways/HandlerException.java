package com.saulo.gateways;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.saulo.gateways.custom_exceptions.DeviceNotFoundException;
import com.saulo.gateways.custom_exceptions.GatewayNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestControllerAdvice
public class HandlerException {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleMethodArgumentiException(MethodArgumentNotValidException exception){
        Map<String, String> errorMap = new HashMap<>();
        List<FieldError> errorList = exception.getBindingResult().getFieldErrors();
        errorList.forEach(error->{
            //errorMap.put(error.getField(),error.getDefaultMessage());
            errorMap.put("error",error.getDefaultMessage());
        });
        return errorMap;
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleHttpMessageNotReadableException(HttpMessageNotReadableException exception) throws IOException {
        Map<String , String> errorMap = new HashMap<>();
        Throwable cause = exception.getCause();
        String field="";
        String error="";
        if(cause instanceof JsonParseException){
            field = ((JsonParseException) cause).getProcessor().currentName();
            error = "Tipo de dato no valido para un JSON";
        }
        if(cause instanceof InvalidFormatException){
            field = ((InvalidFormatException) cause).getPath().get(0).getFieldName();
            error = "Tipo de dato incorrecto para este campo, intente con otro tipo de dato";
        }
        //
        errorMap.put(field, error);
        return errorMap;
    }

    @ExceptionHandler({DeviceNotFoundException.class, GatewayNotFoundException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleEntityNotFound(Exception exception){
        Map<String, String> errorMap=new HashMap<>();
        String message= exception.getMessage();
        String error = "error";
        errorMap.put(error,message);
        return errorMap;
    }
}
