package com.rafaelbp.TrelloClone.exceptions;

public class ListNotFoundException extends RuntimeException {
    public ListNotFoundException(String message) {
        super(message);
    }

    public ListNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ListNotFoundException() {

    }
}
