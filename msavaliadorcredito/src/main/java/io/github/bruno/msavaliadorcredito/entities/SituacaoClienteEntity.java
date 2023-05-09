package io.github.bruno.msavaliadorcredito.entities;

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
