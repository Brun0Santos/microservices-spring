package io.github.bruno.msavaliadorcredito.controller;

import io.github.bruno.msavaliadorcredito.entity.SituacaoClienteEntity;
import io.github.bruno.msavaliadorcredito.exceptions.DataNotFoundException;
import io.github.bruno.msavaliadorcredito.exceptions.ErrorMicroserviceException;
import io.github.bruno.msavaliadorcredito.service.AvaliadorCreditoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/avaliacoes-credito")
public class AvaliadorCreditoController {

    @Autowired
    private AvaliadorCreditoService avaliadorCreditoService;

    @GetMapping
    public String messge() {
        return "ok";
    }

    @GetMapping(value = "situacao-cliente", params = "cpf")
    public ResponseEntity consultarSituacaoCliente(@RequestParam String cpf) {
        try {
            SituacaoClienteEntity situacaoCliente = avaliadorCreditoService.obterSituacaoCliente(cpf);
            return ResponseEntity.ok().body(situacaoCliente);
        } catch (DataNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (ErrorMicroserviceException ex) {
            return ResponseEntity.status(HttpStatus.resolve(ex.getStatus())).body(ex.getMessage());
        } catch (Exception ex){
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }
}
