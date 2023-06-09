package io.github.bruno.msavaliadorcredito.service;

import feign.FeignException;
import io.github.bruno.msavaliadorcredito.configs.CartaoConsumerFeign;
import io.github.bruno.msavaliadorcredito.configs.ClientConsumerFeign;
import io.github.bruno.msavaliadorcredito.configs.PublisherRabbitMQ;
import io.github.bruno.msavaliadorcredito.dto.CartaoAprovadoDto;
import io.github.bruno.msavaliadorcredito.dto.RetornoAvaliacaoDto;
import io.github.bruno.msavaliadorcredito.entities.*;
import io.github.bruno.msavaliadorcredito.exceptions.DataNotFoundException;
import io.github.bruno.msavaliadorcredito.exceptions.ErroSolicitacaoCartaoException;
import io.github.bruno.msavaliadorcredito.exceptions.ErrorMicroserviceException;
import io.github.bruno.msavaliadorcredito.util.LimiteCalculoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class AvaliadorCreditoService {

    @Autowired
    private ClientConsumerFeign clientConsumerFeign;

    @Autowired
    private CartaoConsumerFeign cartaoConsumerFeign;

    @Autowired
    private PublisherRabbitMQ publisherMQService;

    public SituacaoClienteEntity obterSituacaoCliente(String cpf) {
        try {
            ResponseEntity<DadosClienteEntity> dadosClienteResponse = clientConsumerFeign.dadosCliente(cpf);
            ResponseEntity<List<CartaoClienteEntity>> dadosCartaoResponse = cartaoConsumerFeign.dadosCartao(cpf);
            return SituacaoClienteEntity.builder().cliente(dadosClienteResponse.getBody())
                    .cartoes(dadosCartaoResponse.getBody()).build();
        } catch (FeignException.FeignClientException ex) {
            log.info(ex.getMessage());
            if (HttpStatus.NOT_FOUND.value() == ex.status()) throw new DataNotFoundException();
            throw new ErrorMicroserviceException();
        }
    }

    public RetornoAvaliacaoDto realizarAvaliacao(String cpf, Integer renda) {
        try {
            ResponseEntity<DadosClienteEntity> dadosClienteResponse = clientConsumerFeign.dadosCliente(cpf);
            ResponseEntity<List<CartaoEntity>> cartaoResponse = cartaoConsumerFeign.dadosClienteResponse(renda);
            List<CartaoAprovadoDto> listCartoesAprovados = cartaoResponse.getBody().stream().map(card -> {
                BigDecimal limiteAprovado = LimiteCalculoUtil.calculoLimite(dadosClienteResponse.getBody().getIdade(), card.getLimiteCartao());
                return new CartaoAprovadoDto(card.getNome(), card.getBandeiraCartao(), limiteAprovado);
            }).toList();
            return new RetornoAvaliacaoDto(listCartoesAprovados);
        } catch (FeignException.FeignClientException ex) {
            log.info(ex.getMessage());
            if (HttpStatus.NOT_FOUND.value() == ex.status()) throw new DataNotFoundException();
            throw new ErrorMicroserviceException();
        }
    }

    public ProtocoloCartao solicitarEmissaoCartao(DadosSolicitacaoCartaoEntity dados) {
        try {
            publisherMQService.sendToExchangeProduct(dados);
            return new ProtocoloCartao(UUID.randomUUID().toString());
        } catch (Exception ex) {
            log.info(ex.getMessage());
            throw new ErroSolicitacaoCartaoException();
        }
    }
}