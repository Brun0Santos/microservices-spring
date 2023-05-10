package io.github.bruno.mscartoes.dto;

import io.github.bruno.mscartoes.entity.CartaoEntity;
import io.github.bruno.mscartoes.enums.BandeiraCartao;

import java.math.BigDecimal;

public class CartaoDto {
    private Integer id;
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public CartaoDto() {
    }

    public static CartaoEntity toModel(CartaoDto cartaoDto) {
        return new CartaoEntity(cartaoDto.id ,cartaoDto.nome, cartaoDto.bandeira, cartaoDto.renda, cartaoDto.limite);
    }

    public String getNome() {
        return nome;
    }

    public BandeiraCartao getBandeira() {
        return bandeira;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public BigDecimal getLimite() {
        return limite;
    }
}
