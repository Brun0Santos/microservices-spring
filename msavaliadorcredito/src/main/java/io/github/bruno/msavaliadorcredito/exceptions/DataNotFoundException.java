package io.github.bruno.msavaliadorcredito.exceptions;

public class DataNotFoundException extends Exception{
    public DataNotFoundException(){
        super("Dados não encontrado para o CPF informado ");
    }
}
