package br.com.rd.pi.pdv.service.bo;

import br.com.rd.pi.pdv.model.entity.DocumentoFiscalEntity;
import br.com.rd.pi.pdv.model.dto.DocumentoFiscalDTO;
import org.springframework.stereotype.Component;

@Component
public class DocumentoFiscalBO {

    public DocumentoFiscalDTO parseToDTO(DocumentoFiscalEntity entity){
        DocumentoFiscalDTO dto = new DocumentoFiscalDTO();

        if(entity == null)
            return dto;

        dto.setIdDocumentoFiscal(entity.getIdDocumentoFiscal());
        dto.setCdFilial(entity.getCdFilial());
        dto.setIdCliente(entity.getCliente());
        dto.setIdRecarga(entity.getIdRecarga());
        dto.setDataAbertura(entity.getDataAbertura());
        dto.setDataFechamento(entity.getDataFechamento());
        dto.setFlagNota(entity.getFlagNota());
        dto.setValorDocumento(entity.getValorDocumento());
        dto.setNumeroCaixa(entity.getNumeroCaixa());

        return dto;
    }
}
