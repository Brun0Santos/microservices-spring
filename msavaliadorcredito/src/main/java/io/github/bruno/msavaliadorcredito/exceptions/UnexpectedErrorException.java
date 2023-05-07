package io.github.bruno.msavaliadorcredito.exceptions;

public class UnexpectedErrorException extends RuntimeException{
    public UnexpectedErrorException(){
        super("error não esperado");
    }
}
