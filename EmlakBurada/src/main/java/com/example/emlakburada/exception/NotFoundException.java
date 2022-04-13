package com.example.emlakburada.exception;

public class NotFoundException extends ServiceException {
    public NotFoundException() {
        super(RESOURCE_NOT_FOUND, "Requested resource not found");
    }

    public NotFoundException(String errorDescription) {
        super(RESOURCE_NOT_FOUND, errorDescription);
    }
}
