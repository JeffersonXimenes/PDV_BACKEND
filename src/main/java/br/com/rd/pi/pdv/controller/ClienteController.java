package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.model.dto.ClienteDTO;
import br.com.rd.pi.pdv.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/pdv/cliente")
    public ResponseEntity<Object> listarTodosCliente() {
        return ResponseEntity.ok().body(service.buscarTodosCliente());
    }

    @PostMapping("/pdv/cliente")
    public ResponseEntity<Object> inserirCliente(@RequestBody ClienteDTO dto ) {
        service.inserir(dto);
        return ResponseEntity.ok().body(dto);
    }


}
