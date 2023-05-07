package io.github.bruno.mscartoes.dto;

import io.github.bruno.mscartoes.entity.CartaoCliente;

import java.math.BigDecimal;

public class CartaoClienteDto {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;

    public CartaoClienteDto() {
    }

    public CartaoClienteDto(String nome, String bandeira, BigDecimal limiteLiberado) {
        this.nome = nome;
        this.bandeira = bandeira;
        this.limiteLiberado = limiteLiberado;
    }

    public static CartaoClienteDto toModel(CartaoCliente cartaoCliente) {
        return new CartaoClienteDto(cartaoCliente.getCartao().getNome(),
                cartaoCliente.getCartao().getBandeiraCartao().toString(), cartaoCliente.getLimite());
    }

    public String getNome() {
        return nome;
    }

    public String getBandeira() {
        return bandeira;
    }

    public BigDecimal getLimiteLiberado() {
        return limiteLiberado;
    }
}
