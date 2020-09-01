package br.com.rd.pi.pdv.controller;

import br.com.rd.pi.pdv.model.dto.DocumentoFiscalDTO;
import br.com.rd.pi.pdv.model.dto.DocumentoItemDTO;
import br.com.rd.pi.pdv.model.dto.ResultData;
import br.com.rd.pi.pdv.service.DocumentoFiscalService;
import br.com.rd.pi.pdv.service.DocumentoItemService;
import br.com.rd.pi.pdv.service.RecargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocumentoFiscalController {

    @Autowired
    private DocumentoFiscalService documentoFiscalService;

    @Autowired
    private DocumentoItemService documentoItemService;

    @Autowired
    private RecargaService recargaService;


    @PostMapping("/pdv/docVenda")
    public ResponseEntity<Object> inserirDocumentoVenda(@RequestBody DocumentoFiscalDTO dto) {
        ResultData resultData = null;

        if(dto.getFilial() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Campo: cdFilial não informado!");

        if(resultData != null)
            return ResponseEntity.badRequest().body(resultData);

        else {
            try {
                documentoFiscalService.inserirVendaNormal(dto);
                return ResponseEntity.ok().body(dto);
            } catch (Exception e) {
                resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao registrar NF", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(resultData);
            }
        }
    }

    @PostMapping("/pdv/docRecarga")
    public ResponseEntity<Object> inserirDocumentoRecarga(@RequestBody DocumentoFiscalDTO dto) {
        ResultData resultData = null;

        if(dto.getFilial() == null)
            resultData = new ResultData(HttpStatus.BAD_REQUEST.value(),"Campo: cdFilial não informado!");

        if(resultData != null)
            return ResponseEntity.badRequest().body(resultData);

        else {
            try {
                documentoFiscalService.inserirVendaRecarga(dto);
                return ResponseEntity.ok().body(dto);
            } catch (Exception e) {
                resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Ocorreu um erro ao registrar NF", e.getMessage());
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(resultData);
            }
        }
    }

    @GetMapping("pdv/doc")
    public ResponseEntity<Object> buscarDoc(){
        return ResponseEntity.ok().body(documentoFiscalService.buscarTodosDoc());
    }

}
