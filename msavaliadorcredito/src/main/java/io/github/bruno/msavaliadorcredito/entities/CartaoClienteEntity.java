package io.github.bruno.msavaliadorcredito.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoClienteEntity {
    private String nome;
    private String bandeira;
    private BigDecimal limiteLiberado;
}
