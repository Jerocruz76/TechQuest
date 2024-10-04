package com.riwi.TechQuest.application.dto.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class ExceptionResponse extends ExceptionBasic{
    private String message;
}
