package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.service.PagamentoDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PagamentoDocController {

    @Autowired
    private PagamentoDocService service;

    @GetMapping("/pdv/pagamentoDoc")
    public ResponseEntity<Object> listarTodosPagamento() {
        return ResponseEntity.ok().body(service.buscarTodosPagamentos());
    }

}