package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.model.dto.RecargaDTO;
import br.com.rd.pi.pdv.model.dto.ResultData;
import br.com.rd.pi.pdv.service.DocumentoFiscalService;
import br.com.rd.pi.pdv.service.RecargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RecargaController {

    @Autowired
    private RecargaService service;

    @Autowired
    private DocumentoFiscalService documentoFiscalService;

    @GetMapping("/Recarga")
    public ResponseEntity buscarTodas(){
        return ResponseEntity.ok().body(service.buscarTodas());
    }

    @PostMapping("/pdv/Recarga")
    public ResponseEntity inserir(@RequestBody RecargaDTO dto){
        ResultData resultData = null;

        if(dto.getNumeroTelefone() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Campo: Numero do telefone não informado!");

        if(resultData != null)
            return ResponseEntity.badRequest().body(resultData);

        else {
            try {
                service.inserir(dto);
                return ResponseEntity.ok().body(dto);
            } catch (Exception e) {
                resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao registrar a recarga", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(resultData);
            }
        }
    }

    @GetMapping("/Recarga/{idOperadora}")
    public ResponseEntity buscarDsOperadora(@PathVariable("idOperadora") Long idOperadora) {
        return ResponseEntity.ok().body(service.buscarPorIdOperadora(idOperadora));
    }

}