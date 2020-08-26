package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.model.dto.PagamentoDocDTO;
import br.com.rd.pi.pdv.service.PagamentoDocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.PreparedStatement;

@RestController
public class zPagamentoDocController {

    @Autowired
    private PagamentoDocService service;

    @GetMapping("/pdv/pagamentoDoc")
    public ResponseEntity<Object> listarTodosPagamento() {
        return ResponseEntity.ok().body(service.buscarTodosPagamentos());
    }

    @PostMapping("/pdv/pagamentoDoc")
    public ResponseEntity<Object> insercaoPagamento(@RequestBody PagamentoDocDTO dto) {
        service.inserir(dto);
        return ResponseEntity.ok().body(dto);




    }

}