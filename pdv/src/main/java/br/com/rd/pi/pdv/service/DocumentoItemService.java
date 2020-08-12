package br.com.rd.pi.pdv.service;

import br.com.rd.pi.pdv.model.dto.DocumentoItemDTO;
import br.com.rd.pi.pdv.model.entity.DocumentoItemEntity;
import br.com.rd.pi.pdv.repository.DocumentoItemRepository;
import br.com.rd.pi.pdv.service.bo.DocumentoItemBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocumentoItemService {

    @Autowired
    private DocumentoItemRepository repository;

    @Autowired
    private DocumentoItemBO documentoItemBO;

    public DocumentoItemDTO buscarDocumentoId(Long codigo){
        return documentoItemBO.parseToDTO(repository.getOne(codigo));
    }

    public void inserirItem (DocumentoItemDTO dto){
        DocumentoItemEntity entity = documentoItemBO.parseToEntity(dto,null);
        if(entity.getIdDocumento() != null && entity.getNumItemDoc() != null)
            repository.save(entity);
    }
}
