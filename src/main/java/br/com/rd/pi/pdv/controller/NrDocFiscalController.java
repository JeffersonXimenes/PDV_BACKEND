package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.service.NrDocFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NrDocFiscalController {

    @Autowired
    NrDocFiscalService nrDocFiscalService;

    @GetMapping("/pdv/proxNum/{cdFilial}")
    public ResponseEntity<Object> proxNumDocFiscal(@PathVariable("cdFilial") Long cdFilial) {
        return ResponseEntity.ok().body(nrDocFiscalService.buscaNrProxNota(cdFilial));
    }
}