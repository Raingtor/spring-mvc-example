package com.github.Raingtor.controller.exception;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String object, String id) {
        super(String.format("%s with id %s not found.", object, id));
    }
}