package io.github.bruno.msclientes.controller;

import io.github.bruno.msclientes.dto.ClienteDto;
import io.github.bruno.msclientes.entity.ClienteEntity;
import io.github.bruno.msclientes.service.ClienteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@Slf4j
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public String status() {
        log.info("obtendo o status do microservice de cliente");
        return "ok";
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody ClienteDto client) {
        ClienteEntity clienteEntity = ClienteDto.toModel(client);
        service.save(clienteEntity);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}").buildAndExpand(client.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity getDataClient(@PathVariable("cpf") String cpf) {
        Optional<ClienteEntity> cliente = service.getByCpf(cpf);
        if (cliente.isEmpty()) return ResponseEntity.notFound().build();
        return ResponseEntity.ok().body(cliente);
    }
}
