package io.github.bruno.mscartoes.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DadosEmissaoCartao {
    private Integer idCartao;
    private String cpf;
    private String endereco;
    private BigDecimal limiteLiberado;
}
