package io.github.bruno.msavaliadorcredito.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class LimiteCalculoUtil {

    public static BigDecimal calculoLimite(Integer idade, BigDecimal limiteBasico) {
        BigDecimal fator = BigDecimal.valueOf(idade).divide(new BigDecimal("10"));
        return fator.multiply(limiteBasico).setScale(2, RoundingMode.HALF_UP);
    }
}
