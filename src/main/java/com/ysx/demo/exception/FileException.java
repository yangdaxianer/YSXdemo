package com.ysx.demo.exception;

public class FileException extends RuntimeException{
    private static final long serialVersionUID = 7118454467366490865L;

    public FileException(String message) {
        super(message);
    }

    public FileException(String message, Throwable cause) {
        super(message, cause);
    }
}