package ru.geekbrains.java.oop.at.utils;

public class ButtonNotFoundException extends RuntimeException {
    public ButtonNotFoundException() {
        super();
    }

    public ButtonNotFoundException(String message) {
        super(message);
    }

    public ButtonNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public ButtonNotFoundException(Throwable cause) {
        super(cause);
    }

    protected ButtonNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
