package io.github.bruno.msavaliadorcredito.service;

import feign.FeignException;
import io.github.bruno.msavaliadorcredito.config.ClienteFeignCliente;
import io.github.bruno.msavaliadorcredito.entity.DadosClienteEntity;
import io.github.bruno.msavaliadorcredito.entity.SituacaoClienteEntity;
import io.github.bruno.msavaliadorcredito.exceptions.DataNotFoundException;
import io.github.bruno.msavaliadorcredito.exceptions.ErrorMicroserviceException;
import io.github.bruno.msavaliadorcredito.exceptions.UnexpectedErrorException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AvaliadorCreditoService {

    @Autowired
    private ClienteFeignCliente feignCliente;

    public SituacaoClienteEntity obterSituacaoCliente(String cpf) throws DataNotFoundException, ErrorMicroserviceException {
        try {
            ResponseEntity<DadosClienteEntity> dadosClienteResponse = feignCliente.dadosCliente(cpf);
            return SituacaoClienteEntity.builder().cliente(dadosClienteResponse.getBody()).build();
        } catch (FeignException.FeignClientException ex) {
            if (HttpStatus.NOT_FOUND.value() == ex.status()) {
                throw new DataNotFoundException();
            }
            throw new ErrorMicroserviceException(ex.getMessage(), ex.status());
        } catch (Exception ex) {
            log.info(ex.getMessage());
            ex.printStackTrace();
            throw new UnexpectedErrorException();
        }
    }
}
