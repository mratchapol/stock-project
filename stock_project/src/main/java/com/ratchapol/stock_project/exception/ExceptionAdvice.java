package com.ratchapol.stock_project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionAdvice {
    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND) // ทำให้ HTTP status ที่ถูกต้องถูกส่งกลับมาด้วย
    String handlerNotFoundException(ProductNotFoundException exception){
        return exception.getMessage();
    }
    
    @ExceptionHandler
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    String handlerStorageException(StorageException exception){
        return exception.getMessage();
    }
}