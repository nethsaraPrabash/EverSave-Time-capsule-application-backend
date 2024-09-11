package com.timecapsule.eversave.eversave.advice;

import com.timecapsule.eversave.eversave.dto.responsebody.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLIntegrityConstraintViolationException;

@RestControllerAdvice(basePackages = "com.timecapsule.eversave.eversave.controller.UserController")
public class UserAdvice {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseBody handleException(SQLIntegrityConstraintViolationException e) {
        ResponseBody res = new ResponseBody();
        res.addResponse("error", e.getMessage());
        res.addResponse("message", "User already exists");
        return res;
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseBody handleException(MethodArgumentNotValidException e) {
        ResponseBody res = new ResponseBody();
        e.getBindingResult().getAllErrors().forEach(error -> {
            res.addResponse("error", error.getDefaultMessage());
        });
        return res;
    }
}
