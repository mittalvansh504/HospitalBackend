package com.example.HealthManagement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("status", false);
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Handles all other unexpected errors
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<Map<String, Object>> handleThrowable(Throwable ex) {

        Map<String, Object> response = new HashMap<>();
        response.put("status", false);
        response.put("message", "Something went wrong");

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    // This will be use for seeing the error in our code


//    @ExceptionHandler(Throwable.class)
//    public ResponseEntity<Map<String, Object>> handleThrowable(Throwable ex) {
//
//        ex.printStackTrace();   // VERY IMPORTANT
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("status", false);
//        response.put("message", ex.getMessage());  // show real error
//
//        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

}
