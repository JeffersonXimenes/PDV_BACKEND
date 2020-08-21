package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.dto.DocumentoItemDTO;
import br.com.rd.pi.pdv.model.entity.DocumentoItemEntity;
import br.com.rd.pi.pdv.repository.DocumentoFiscalRepository;
import br.com.rd.pi.pdv.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DocumentoItemBO {

    @Autowired
    private DocumentoFiscalRepository docFiscalRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public DocumentoItemDTO parseToDTO(DocumentoItemEntity entity){
        DocumentoItemDTO dto = new DocumentoItemDTO();

        if(entity == null)
            return dto;

        dto.setDocumentoFiscal(entity.getDocumentoFiscal().getIdDocumentoFiscal());
        dto.setNumItemDoc(entity.getNumItemDoc());
        dto.setCdProduto(entity.getCdProduto().getCdProduto());
        dto.setQtdItem(entity.getQtdItem());
        dto.setValorItem(entity.getValorItem());
        dto.setPorcentoIcms(entity.getPorcentoIcms());
        dto.setValorIcms(entity.getValorIcms());

        return dto;
    }

    public DocumentoItemEntity parseToEntity(DocumentoItemDTO dto, DocumentoItemEntity entity){
        if (entity == null)
            entity = new DocumentoItemEntity();

        if (dto == null)
            return entity;

        entity.setDocumentoFiscal(docFiscalRepository.getOne(dto.getDocumentoFiscal()));
        entity.setNumItemDoc(dto.getNumItemDoc());
        entity.setCdProduto(produtoRepository.getOne(dto.getCdProduto()));
        entity.setQtdItem(dto.getQtdItem());
        entity.setValorItem(dto.getValorItem());
        entity.setPorcentoIcms(dto.getPorcentoIcms());
        entity.setValorIcms(dto.getValorIcms());

        return entity;
    }
}
