package io.github.bruno.mscartoes.service;

import io.github.bruno.mscartoes.entity.CartaoCliente;
import io.github.bruno.mscartoes.repository.CartaoClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoClienteService {
    @Autowired
    private CartaoClienteRepository repository;

    public List<CartaoCliente> listCartaoByCpf(String cpf) {
        return repository.findByCpf(cpf);
    }
}
