//package com.example.befix.exception;
//
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.UUID;
//
//@RestControllerAdvice
//public class GlobalExceptionHandler {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public campaign.response.ErrorResponse<List<ValidationError>> handleValidationException(MethodArgumentNotValidException ex) {
//        List<ValidationError> errors = new ArrayList<>();
//        ex.getBindingResult().getFieldErrors()
//                .forEach(fieldError -> {
//                    ValidationError validationError = new ValidationError();
//                    validationError.setReference(fieldError.getField());
//                    validationError.setMessage(fieldError.getDefaultMessage());
//                    errors.add(validationError);
//                });
//        return new campaign.response.ErrorResponse<>(HttpStatus.BAD_REQUEST.value(), "Validation Error ", errors);
//    }
//
//    @ExceptionHandler(StringException.class)
//    public ResponseEntity<ErrorResponse> handleException(StringException ex) {
//        var errorResponse = ErrorResponse.builder()
//                .uuid(UUID.randomUUID())
//                .errors(Collections.singletonList(new Error(HttpStatus.BAD_REQUEST, ex.getMessage())))
//                .build();
//
//        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
//    }
//
//}