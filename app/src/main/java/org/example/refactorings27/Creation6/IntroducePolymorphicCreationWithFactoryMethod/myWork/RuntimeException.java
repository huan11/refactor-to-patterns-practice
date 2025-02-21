package org.example.refactorings27.Creation6.IntroducePolymorphicCreationWithFactoryMethod.myWork;

public class RuntimeException extends Exception {
    public RuntimeException() {
        super();
    }

    public RuntimeException(String message) {
        super(message);
    }

    public RuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    protected RuntimeException(Throwable cause) {
        super(cause);
    }
} 