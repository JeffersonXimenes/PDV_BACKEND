package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.service.OperadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperadoraController {

    @Autowired
    private OperadoraService operadoraService;

    @GetMapping("/pdv/operadoras")
    public ResponseEntity<Object> listarTodasOperadoras() {
        return ResponseEntity.ok().body(operadoraService.buscarOperadora());
    }

    @GetMapping("/pdv/operadoras/{idOperadora}")
    public ResponseEntity listarOperadoraId(@PathVariable("idOperadora") Long idOperadora) {
        return ResponseEntity.ok().body(operadoraService.buscarOperadoraId(idOperadora));
    }
}
