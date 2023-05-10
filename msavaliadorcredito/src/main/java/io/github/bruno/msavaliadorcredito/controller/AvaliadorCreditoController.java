package io.github.bruno.msavaliadorcredito.controller;

import io.github.bruno.msavaliadorcredito.dto.RetornoAvaliacaoDto;
import io.github.bruno.msavaliadorcredito.entities.DadosAvaliacaoEntity;
import io.github.bruno.msavaliadorcredito.entities.DadosSolicitacaoCartaoEntity;
import io.github.bruno.msavaliadorcredito.entities.ProtocoloCartao;
import io.github.bruno.msavaliadorcredito.entities.SituacaoClienteEntity;
import io.github.bruno.msavaliadorcredito.service.AvaliadorCreditoService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avaliacoes-credito")
public class AvaliadorCreditoController {

    @Autowired
    private AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String message() {
        return "ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity<SituacaoClienteEntity> consultarSituacaoCliente(@RequestParam String cpf) {
        SituacaoClienteEntity situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
        return ResponseEntity.ok().body(situacaoCliente);
    }

    @PostMapping
    public ResponseEntity<RetornoAvaliacaoDto> realizarAvaliacao(@RequestBody DadosAvaliacaoEntity dados) {
        RetornoAvaliacaoDto retornoAvaliacaoDto = avaliadorCreditoService.realizarAvaliacao(dados.getCpf(), dados.getRenda());
        return ResponseEntity.ok().body(retornoAvaliacaoDto);
    }

    @PostMapping("/solicitacoes-cartoes")
    public ResponseEntity<ProtocoloCartao> solicitarCartao(@RequestBody DadosSolicitacaoCartaoEntity dados) {
        ProtocoloCartao protocoloCartao = avaliadorCreditoService.solicitarEmissaoCartao(dados);
        return ResponseEntity.ok().body(protocoloCartao);
    }
}
