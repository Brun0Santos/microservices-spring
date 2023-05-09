package io.github.bruno.msavaliadorcredito.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartaoEntity {
    private Integer id;
    private String nome;
    private String bandeiraCartao;
    private BigDecimal limiteCartao;

}
