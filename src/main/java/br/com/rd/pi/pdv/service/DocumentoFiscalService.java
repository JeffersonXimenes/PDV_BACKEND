package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.DocumentoFiscalDTO;
import br.com.rd.pi.pdv.model.entity.DocumentoFiscalEntity;
import br.com.rd.pi.pdv.repository.DocumentoFiscalRepository;
import br.com.rd.pi.pdv.service.bo.DocumentoFiscalBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentoFiscalService {

    @Autowired
    private DocumentoFiscalRepository repository;

    @Autowired
    private DocumentoFiscalBO documentoFiscalBO;

    public List<DocumentoFiscalDTO> buscarTodosDoc(){
        List <DocumentoFiscalDTO> listaDocumento = new ArrayList<>();

        for (DocumentoFiscalEntity entity: repository.findAll()) {
            DocumentoFiscalDTO dto = documentoFiscalBO.parseToDTO(entity);
            listaDocumento.add(dto);
        }
        return listaDocumento;
    }
}
