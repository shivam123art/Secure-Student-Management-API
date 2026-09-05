package com.shivam.studentmanagenement.exception;

import java.util.HashMap;
import java.util.Map;
import com.shivam.studentmanagenement.exception.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleValiddationException(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            errors.put(error.getField(), error.getDefaultMessage());
        });

        return new ErrorResponse(
            400,
            "validation failed: " ,
            java.time.LocalDateTime.now().toString()
            ,errors
        );
    }
    @ExceptionHandler(StudentNotFoundException.class)
@ResponseStatus(HttpStatus.NOT_FOUND)
public ErrorResponse handleStudentNotFoundException(
        StudentNotFoundException ex) {

    return new ErrorResponse(
            404,
            ex.getMessage(),
            java.time.LocalDateTime.now().toString(),
            null
    );
}
}
