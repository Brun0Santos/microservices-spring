package io.github.bruno.msavaliadorcredito.configs;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {
    public static final String EXG_NAME = "emissao-cartoes.direct";
    public static final String QUEUE = "emissao-cartoes";
    public static final String ROUTING_KEY = "cards";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true, false, false);
    }

    @Bean
    public DirectExchange exchange() {
        return new DirectExchange(EXG_NAME, false, false);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with(ROUTING_KEY);
    }
}
