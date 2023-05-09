package io.github.bruno.msavaliadorcredito.configs;

import io.github.bruno.msavaliadorcredito.entities.CartaoClienteEntity;
import io.github.bruno.msavaliadorcredito.entities.CartaoEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Configuration
@FeignClient(value = "mscartoes", path = "/cartoes")
public interface CartaoConsumerFeign {

    @GetMapping("/{cpf}")
    @Bean
    ResponseEntity<List<CartaoClienteEntity>> dadosCartao(@PathVariable String cpf);

    @GetMapping(params = "renda")
    @Bean
    ResponseEntity<List<CartaoEntity>> dadosClienteResponse(@RequestParam("renda") Integer renda);
}
