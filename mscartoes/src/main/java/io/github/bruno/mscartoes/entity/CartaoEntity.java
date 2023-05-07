package io.github.bruno.mscartoes.entity;

import io.github.bruno.mscartoes.enums.BandeiraCartao;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_cartao")
public class CartaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeiraCartao;
    private BigDecimal renda;
    private BigDecimal limiteCartao;

    public CartaoEntity() {
    }

    public CartaoEntity(String nome, BandeiraCartao bandeiraCartao, BigDecimal renda, BigDecimal limiteCartao) {
        this.nome = nome;
        this.bandeiraCartao = bandeiraCartao;
        this.renda = renda;
        this.limiteCartao = limiteCartao;
    }

    public String getNome() {
        return nome;
    }

    public BandeiraCartao getBandeiraCartao() {
        return bandeiraCartao;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public BigDecimal getLimiteCartao() {
        return limiteCartao;
    }
}