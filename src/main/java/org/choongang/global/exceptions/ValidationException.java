package org.choongang.global.exceptions;

public class ValidationException extends CommonException{
    public ValidationException(String message) {
        super(message, 400);
    }
}
