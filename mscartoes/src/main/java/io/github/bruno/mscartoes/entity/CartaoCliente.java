package io.github.bruno.mscartoes.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class CartaoCliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;
    @ManyToOne
    @JoinColumn(name = "id_cartao")
    private CartaoEntity cartao;
    private BigDecimal limite;

    public CartaoCliente() {
    }

    public String getCpf() {
        return cpf;
    }

    public CartaoEntity getCartao() {
        return cartao;
    }

    public BigDecimal getLimite() {
        return limite;
    }
}
