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

    public CartaoCliente(Integer id, String cpf, CartaoEntity cartao, BigDecimal limite) {
        this.id = id;
        this.cpf = cpf;
        this.cartao = cartao;
        this.limite = limite;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setCartao(CartaoEntity cartao) {
        this.cartao = cartao;
    }

    public void setLimite(BigDecimal limite) {
        this.limite = limite;
    }
}
