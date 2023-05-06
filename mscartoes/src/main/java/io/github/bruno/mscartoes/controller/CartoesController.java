package io.github.bruno.mscartoes.controller;

import io.github.bruno.mscartoes.dto.CartaoDto;
import io.github.bruno.mscartoes.entity.CartaoEntity;
import io.github.bruno.mscartoes.service.CartaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cartoes")
public class CartoesController {

    @Autowired
    private CartaoService service;

    @GetMapping
    public String status() {
        return "ok";
    }

    @PostMapping
    public ResponseEntity cadastrar(@RequestBody CartaoDto cartaoDto) {
        CartaoEntity cartao = CartaoDto.toModel(cartaoDto);
        service.salvarCartao(cartao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
