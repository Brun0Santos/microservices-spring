package io.github.bruno.msavaliadorcredito.exceptions;

import lombok.Getter;

public class ErrorMicroserviceException extends Exception {
    @Getter
    private final Integer status;

    public ErrorMicroserviceException(String message, Integer status) {
        super(message);
        this.status = status;
    }
}
