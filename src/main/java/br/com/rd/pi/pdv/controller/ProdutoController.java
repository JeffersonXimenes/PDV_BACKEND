package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.model.entity.LmpmItemEntity;
import br.com.rd.pi.pdv.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        List<LmpmItemEntity> listProdutosLmpm = service.teste(codigo);

        if (listProdutosLmpm.size() > 0)
            return ResponseEntity.ok().body(listProdutosLmpm.get(0));
        else
            return ResponseEntity.ok().body(service.buscarProdutoId(codigo));
    }

}
