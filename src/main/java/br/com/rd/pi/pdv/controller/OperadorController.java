package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.service.ClienteService;
import br.com.rd.pi.pdv.service.OperadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperadorController {

    @Autowired
    private OperadorService service;

    @GetMapping("/pdv/operador/{numMatricula}")
    public ResponseEntity buscarOperadorMatricula(@PathVariable("numMatricula") String numMatricula) {
        return ResponseEntity.ok().body(service.buscarOperadorMatricula(numMatricula));
    }
}
