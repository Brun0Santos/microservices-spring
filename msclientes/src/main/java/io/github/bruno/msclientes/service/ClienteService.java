package io.github.bruno.msclientes.service;

import io.github.bruno.msclientes.entity.ClienteEntity;
import io.github.bruno.msclientes.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Transactional
    public ClienteEntity save(ClienteEntity client) {
        return repository.save(client);
    }

    public Optional<ClienteEntity> getByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
