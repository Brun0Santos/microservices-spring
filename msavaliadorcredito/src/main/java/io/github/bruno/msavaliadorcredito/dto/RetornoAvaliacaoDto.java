package io.github.bruno.msavaliadorcredito.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class RetornoAvaliacaoDto {
    private List<CartaoAprovadoDto> cartoes;
}
