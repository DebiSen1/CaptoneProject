package com.upgrad.bookmyconsultation.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class InvalidInputException extends RuntimeException{
    public InvalidInputException(String errMsg) {
        super(errMsg);
    }

    private List<String> attributeNames;
}
