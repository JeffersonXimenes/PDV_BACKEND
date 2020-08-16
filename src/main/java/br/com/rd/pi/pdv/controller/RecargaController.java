package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.model.dto.RecargaDTO;
import br.com.rd.pi.pdv.service.RecargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/Recarga/{idOperadora}")
    public ResponseEntity buscarDsOperadora(@PathVariable("idOperadora") Long idOperadora) {
        return ResponseEntity.ok().body(service.buscarPorIdOperadora(idOperadora));
    }

}