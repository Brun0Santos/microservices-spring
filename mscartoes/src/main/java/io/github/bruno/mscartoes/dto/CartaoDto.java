package io.github.bruno.mscartoes.dto;

import io.github.bruno.mscartoes.entity.CartaoEntity;
import io.github.bruno.mscartoes.enums.BandeiraCartao;

import java.math.BigDecimal;

public class CartaoDto {
    private String nome;
    private BandeiraCartao bandeira;
    private BigDecimal renda;
    private BigDecimal limite;

    public CartaoDto() {
    }

    public static CartaoEntity toModel(CartaoDto cartaoDto) {
        return new CartaoEntity(cartaoDto.nome, cartaoDto.bandeira, cartaoDto.renda, cartaoDto.limite);
    }

}
