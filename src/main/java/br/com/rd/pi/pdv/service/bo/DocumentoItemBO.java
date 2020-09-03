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

    @Autowired
    private ProdutoBO produtoBO;

    public DocumentoItemDTO parseToDTO(DocumentoItemEntity entity){
        DocumentoItemDTO dto = new DocumentoItemDTO();

        if(entity == null)
            return dto;

        dto.setDocumentoFiscal(entity.getDocumentoFiscal().getIdDocumentoFiscal());
        dto.setNumItemDoc(entity.getNumItemDoc());
        dto.setProduto(produtoBO.parseToDTO(entity.getProduto()));
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

        entity.setQtdItem(dto.getQtdItem());
        entity.setNumItemDoc(dto.getNumItemDoc());
        entity.setProduto(produtoRepository.getOne(dto.getProduto().getCdProduto()));
        entity.setValorItem(dto.getValorItem());

        return entity;
    }
}
