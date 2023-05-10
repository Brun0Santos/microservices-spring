package io.github.bruno.mscartoes.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bruno.mscartoes.dto.DadosEmissaoCartao;
import io.github.bruno.mscartoes.entity.CartaoCliente;
import io.github.bruno.mscartoes.entity.CartaoEntity;
import io.github.bruno.mscartoes.repository.CartaoClienteRepository;
import io.github.bruno.mscartoes.repository.CartaoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConsumerMQService {
    @Autowired
    private CartaoClienteRepository cartaoClienteRepository;

    @Autowired
    private CartaoRepository cartaoRepository;

    public void consumerDadosDaFila(String dados) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            DadosEmissaoCartao dadosEmissaoCartao = mapper.readValue(dados, DadosEmissaoCartao.class);
            CartaoEntity dadosCartao = cartaoRepository.findById(dadosEmissaoCartao.getIdCartao()).orElseThrow();
            CartaoCliente cliente = new CartaoCliente();
            cliente.setCartao(dadosCartao);
            cliente.setCpf(dadosEmissaoCartao.getCpf());
            cliente.setLimite(dadosCartao.getLimiteCartao());
            cartaoClienteRepository.save(cliente);
        } catch (Exception ex) {
            log.error("Erro ao receber solicitacao de emissao de cartao: {} ", ex.getMessage());
            ex.getCause();
        }
    }
}
