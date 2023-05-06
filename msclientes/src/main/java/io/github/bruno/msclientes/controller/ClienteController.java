package io.github.bruno.msclientes.controller;

import io.github.bruno.msclientes.dto.ClienteDto;
import io.github.bruno.msclientes.entity.ClienteEntity;
import io.github.bruno.msclientes.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity saveUser(@RequestBody ClienteDto client) {
        ClienteEntity clienteEntity = ClienteDto.toModel(client);
        System.out.println(clienteEntity);
        service.save(clienteEntity);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}").buildAndExpand(client.getCpf()).toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping("/{cpf}")
    public ResponseEntity getDataClient(@PathVariable("cpf") String cpf) {
        Optional<ClienteEntity> cliente = service.getByCpf(cpf);
        System.out.println("aaaa");
        System.out.println(cliente);
        if (cliente.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(cliente);
    }
}
