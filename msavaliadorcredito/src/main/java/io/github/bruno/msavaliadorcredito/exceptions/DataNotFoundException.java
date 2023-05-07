package io.github.bruno.msavaliadorcredito.exceptions;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(){
        super("Dados não encontrado para o CPF informado ");
    }
}
