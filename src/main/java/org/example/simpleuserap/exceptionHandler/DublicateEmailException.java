package org.example.simpleuserap.exceptionHandler;

public class DublicateEmailException extends Exception {
    public DublicateEmailException(String message) {
        super(message);
    }
}
