package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping("/produtos/{codigo}")
    public ResponseEntity buscarProduto(@PathVariable("codigo") Long codigo){
        return ResponseEntity.ok().body(service.buscarProdutoId(codigo));
    }

    @GetMapping("/produto/{codigo}")
    public ResponseEntity buscarProdutoLmpm(@PathVariable("codigo") Long codigo){

        if (service.buscarProdutoLmpmId(codigo) != null)
            return ResponseEntity.ok().body(service.buscarProdutoLmpmId(codigo));
        else
            return ResponseEntity.ok().body(service.buscarProdutoId(codigo));
    }

}
