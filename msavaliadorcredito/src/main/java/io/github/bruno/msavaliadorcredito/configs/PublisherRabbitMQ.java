package io.github.bruno.msavaliadorcredito.configs;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.github.bruno.msavaliadorcredito.configs.RabbitMQConfig;
import io.github.bruno.msavaliadorcredito.entities.DadosSolicitacaoCartaoEntity;
import io.github.bruno.msavaliadorcredito.util.ConvertEntityToJsonUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublisherRabbitMQ {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendToExchangeProduct(DadosSolicitacaoCartaoEntity dados) throws JsonProcessingException {
        String dadosConvertidos = ConvertEntityToJsonUtil.convertEntityToJson(dados);
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXG_NAME, RabbitMQConfig.ROUTING_KEY, dadosConvertidos);
    }
}
