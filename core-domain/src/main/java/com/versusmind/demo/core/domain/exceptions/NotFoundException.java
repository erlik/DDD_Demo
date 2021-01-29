package com.versusmind.demo.core.domain.exceptions;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        super("Ressource not found");
    }

    public NotFoundException(String message) {
        super(message);
    }
}
