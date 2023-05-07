package io.github.bruno.msavaliadorcredito.config;

import io.github.bruno.msavaliadorcredito.entity.CartaoClienteEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Configuration
@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartaoConsumerFeign {

    @GetMapping("/{cpf}")
    @Bean
    ResponseEntity<List<CartaoClienteEntity>> dadosCartao(@PathVariable String cpf);
}
