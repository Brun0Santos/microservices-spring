package io.github.bruno.msavaliadorcredito.config;

import io.github.bruno.msavaliadorcredito.entity.DadosClienteEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "msclientes", path = "/clientes")
@Configuration
public interface ClienteFeignCliente {

    @Bean
    @GetMapping("/{cpf}")
    ResponseEntity<DadosClienteEntity> dadosCliente(@PathVariable("cpf") String cpf);
}
