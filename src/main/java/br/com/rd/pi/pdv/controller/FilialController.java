package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.service.FilialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FilialController {

    @Autowired
    private FilialService service;

    @GetMapping("/filial/{codigo}")
    public ResponseEntity buscarFilial(@PathVariable("codigo") Long codigo){
        return ResponseEntity.ok().body(service.BuscarFilial(codigo));
    }
}