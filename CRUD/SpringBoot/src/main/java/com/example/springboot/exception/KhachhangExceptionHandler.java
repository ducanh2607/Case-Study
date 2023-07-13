package com.example.springboot.exception;

import com.example.springboot.service.ServiceResult;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class KhachhangExceptionHandler  {
    @ExceptionHandler(KhachhangNotFoundException.class)
    @ResponseStatus(HttpStatus.OK)
    public ServiceResult<Void> handleKhachhangNotFoundException(){
        return  new ServiceResult<>(null, false, "Khach hang khong ton tai", ServiceResult.Status.NOT_FOUND);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    public ServiceResult<Map<String, List<String>>> notValid(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(err -> {
            errors.add(err.getDefaultMessage());
        });
        Map<String, List<String>> result = new HashMap<>();
        result.put("errors", errors);
        return new ServiceResult<>(result, false, "Khong dung dinh dang", ServiceResult.Status.BAD_REQUEST);
    }
}

