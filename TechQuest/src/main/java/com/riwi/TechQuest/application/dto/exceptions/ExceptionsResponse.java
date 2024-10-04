package com.riwi.TechQuest.application.dto.exceptions;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Setter
@Getter
@SuperBuilder
public class ExceptionsResponse extends ExceptionBasic{
    private List<String> errors;
}
