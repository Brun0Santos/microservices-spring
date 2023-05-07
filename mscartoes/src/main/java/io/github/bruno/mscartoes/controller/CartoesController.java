package io.github.bruno.mscartoes.controller;

import io.github.bruno.mscartoes.dto.CartaoClienteDto;
import io.github.bruno.mscartoes.dto.CartaoDto;
import io.github.bruno.mscartoes.entity.CartaoCliente;
import io.github.bruno.mscartoes.entity.CartaoEntity;
import io.github.bruno.mscartoes.service.CartaoClienteService;
import io.github.bruno.mscartoes.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cartoes")
public class CartoesController {

    @Autowired
    private CartaoService cartaoService;

    @Autowired
    private CartaoClienteService cartaoClienteService;

    @GetMapping()
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CartaoDto cartaoDto) {
        CartaoEntity cartao = CartaoDto.toModel(cartaoDto);
        System.out.println(cartao);
        cartaoService.salvarCartao(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping(params = "renda")
    public ResponseEntity<List<CartaoEntity>> getCartaoComRendaAte(@RequestParam("renda") Long renda) {
        List<CartaoEntity> cartoesRendaMenorIgual = cartaoService.getCartoesRendaMenorIgual(renda);
        return ResponseEntity.ok().body(cartoesRendaMenorIgual);
    }

    @GetMapping("/{cpf}")
    public ResponseEntity<List<CartaoClienteDto>> getCartoesByCliente(@PathVariable String cpf) {
        List<CartaoCliente> cartaoClientes = cartaoClienteService.listCartaoByCpf(cpf);
        List<CartaoClienteDto> resultList = cartaoClientes.stream().
                map(CartaoClienteDto::toModel).collect(Collectors.toList());
        return ResponseEntity.ok().body(resultList);
    }
}
