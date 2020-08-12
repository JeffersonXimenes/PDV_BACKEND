package br.com.rd.pi.pdv.model.dto;

import lombok.Data;

@Data
public class DocumentoItemDTO {

    private Long idDocumento;

    private Long numItemDoc;

    private Long cdProduto;

    private Long qtdItem;

    private Double valorItem;

    private Double porcentoIcms;

    private Double valorIcms;
}
