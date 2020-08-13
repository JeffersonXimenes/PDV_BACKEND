package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.model.dto.RecargaDTO;
import br.com.rd.pi.pdv.service.RecargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecargaController {

    @Autowired
    private RecargaService service;

    @GetMapping("/Recarga")
    public ResponseEntity buscarTodas(){
        return ResponseEntity.ok().body(service.buscarTodas());
    }

    @PostMapping("/pdv/Recarga")
    public ResponseEntity inserir(@RequestBody RecargaDTO dto){
        service.inserir(dto);

        return ResponseEntity.ok().body(dto);
    }

}