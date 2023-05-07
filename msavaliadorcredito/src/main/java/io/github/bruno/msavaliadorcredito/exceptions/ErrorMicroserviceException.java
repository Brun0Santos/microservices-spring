package io.github.bruno.msavaliadorcredito.exceptions;

public class ErrorMicroserviceException extends RuntimeException{
    public ErrorMicroserviceException(){
        super("error não esperado, entre em contado com o admin!!");
    }
}
