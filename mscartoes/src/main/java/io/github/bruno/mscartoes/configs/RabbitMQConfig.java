package io.github.bruno.mscartoes.configs;

import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    private final static String QUEUE_EMISSAO_CARTOES = "emissao-cartoes";
}
