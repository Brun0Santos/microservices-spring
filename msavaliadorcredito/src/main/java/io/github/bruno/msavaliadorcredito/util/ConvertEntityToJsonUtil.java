package io.github.bruno.msavaliadorcredito.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bruno.msavaliadorcredito.entities.DadosSolicitacaoCartaoEntity;

public class ConvertEntityToJsonUtil {
    public static String convertEntityToJson(DadosSolicitacaoCartaoEntity dados) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(dados);
    }
}
