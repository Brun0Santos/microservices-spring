package io.github.bruno.msavaliadorcredito.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DadosSolicitacaoCartaoEntity {
    private Integer idCartao;
    private String cpf;
    private String endereco;
    private BigDecimal limiteLiberado;
}
