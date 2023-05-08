package io.github.bruno.msavaliadorcredito.controller;

import io.github.bruno.msavaliadorcredito.dto.RetornoAvaliacaoDto;
import io.github.bruno.msavaliadorcredito.entity.DadosAvaliacaoEntity;
import io.github.bruno.msavaliadorcredito.entity.SituacaoClienteEntity;
import io.github.bruno.msavaliadorcredito.service.AvaliadorCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes-credito")
public class AvaliadorCreditoController {

    @Autowired
    private AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String messge() {
        return "ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity<SituacaoClienteEntity> consultarSituacaoCliente(@RequestParam String cpf) {
        SituacaoClienteEntity situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
        return ResponseEntity.ok().body(situacaoCliente);
    }

    @PostMapping
    public ResponseEntity realizarAvaliacao(@RequestBody DadosAvaliacaoEntity dados) {
        RetornoAvaliacaoDto retornoAvaliacaoDto = avaliadorCreditoService.realizarAvaliacao(dados.getCpf(), dados.getRenda());
        return ResponseEntity.ok().body(retornoAvaliacaoDto);
    }
}
