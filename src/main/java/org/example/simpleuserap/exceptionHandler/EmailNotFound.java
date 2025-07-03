package org.example.simpleuserap.exceptionHandler;

public class EmailNotFound extends Exception{
    public EmailNotFound(String message) {
        super(message);
    }
}
