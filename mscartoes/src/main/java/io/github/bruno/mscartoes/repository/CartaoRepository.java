package io.github.bruno.mscartoes.repository;

import io.github.bruno.mscartoes.entity.CartaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface CartaoRepository extends JpaRepository<CartaoEntity, Integer> {
    List<CartaoEntity> findByRendaLessThanEqual(BigDecimal rendaBigDecimal);
}
