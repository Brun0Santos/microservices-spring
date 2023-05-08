package io.github.bruno.msavaliadorcredito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class CartaoAprovadoDto {
    private String cartao;
    private String bandeira;
    private BigDecimal limiteAprovado;

}
