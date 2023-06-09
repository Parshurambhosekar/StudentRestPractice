package com.parshuram.studentrest.exception;

import com.parshuram.studentrest.binding.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ApiResponse> handleStudentNotFoundException(StudentNotFoundException exception) {

        String message = exception.getMessage();

        ApiResponse response = new ApiResponse(message);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleMethodArgNotValidException(MethodArgumentNotValidException exception){

        Map<String,String> rsp=new HashMap<>();

        exception.getBindingResult().getAllErrors().forEach(error->{

            String fieldName = ((FieldError) error).getField();

            String message = error.getDefaultMessage();

            rsp.put(fieldName,message);
        });

        return new ResponseEntity<>(rsp,HttpStatus.BAD_REQUEST);
    }








}
