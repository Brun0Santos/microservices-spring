package io.github.bruno.msavaliadorcredito.exceptions;

public class ErroSolicitacaoCartaoException extends RuntimeException {
    public ErroSolicitacaoCartaoException(){
        super("Erro ao solicitar o cartão");
    }
}
