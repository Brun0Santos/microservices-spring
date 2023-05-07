package io.github.bruno.msavaliadorcredito.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SituacaoClienteEntity {
    private DadosClienteEntity cliente;
    private List<CartaoClienteEntity> cartoes;
}
