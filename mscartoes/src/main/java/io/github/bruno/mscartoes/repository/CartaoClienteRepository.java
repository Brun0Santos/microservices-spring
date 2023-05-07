package io.github.bruno.mscartoes.repository;

import io.github.bruno.mscartoes.entity.CartaoCliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartaoClienteRepository extends JpaRepository<CartaoCliente, Integer> {
    List<CartaoCliente> findByCpf(String cpf);
}
