package com.riwi.TechQuest.application.exceptions;

import com.riwi.TechQuest.application.dto.exceptions.ExceptionBasic;
import com.riwi.TechQuest.application.dto.exceptions.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserNotFound {
    @ExceptionHandler(UsernameNotFoundException.class)
    public ExceptionBasic userNotFoundException(UsernameNotFoundException exception){

        return ExceptionResponse.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .status(HttpStatus.NOT_FOUND.name())
                .message(exception.getMessage())
                .build();
    }
}
