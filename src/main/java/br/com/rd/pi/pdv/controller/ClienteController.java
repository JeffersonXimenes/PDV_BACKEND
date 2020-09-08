package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.model.dto.ClienteDTO;
import br.com.rd.pi.pdv.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping("/pdv/cliente")
    public ResponseEntity<Object> listarTodosCliente() {
        return ResponseEntity.ok().body(service.buscarTodosCliente());
    }

    @GetMapping("/pdv/cliente/{numCpf}")
    public ResponseEntity buscarClienteCpf(@PathVariable("numCpf") String numCpf) {
        return ResponseEntity.ok().body(service.buscarClienteCpf(numCpf));
    }

    @PostMapping("/pdv/cliente")
    public ResponseEntity<Object> inserirCliente(@RequestBody ClienteDTO dto) {
//        if (service.buscarClienteCpf(dto.getNumeroCpf()) != null)
//            return ResponseEntity.ok().body(dto); //caso o cliente ja exista na db, retorna o proprio dto e nao insere no db
        service.inserir(dto);
        return ResponseEntity.ok().body(dto);
    }

}
