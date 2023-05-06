package io.github.bruno.mscartoes.service;

import io.github.bruno.mscartoes.entity.CartaoEntity;
import io.github.bruno.mscartoes.repository.CartaoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CartaoService {
    @Autowired
    private CartaoRepository repository;

    @Transactional
    public CartaoEntity salvarCartao(CartaoEntity cartao) {
        return repository.save(cartao);
    }

    public List<CartaoEntity> getCartoesRendaMenorIgual(Integer renda) {
        BigDecimal rendaBigDecimal = BigDecimal.valueOf(renda);
        return repository.findByRendaLessThanEqual(rendaBigDecimal);
    }

}
