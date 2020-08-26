package br.com.rd.pi.pdv.model.dto;

import lombok.Data;

@Data
public class DocumentoItemDTO {

    private Long documentoFiscal;

    private Long numItemDoc;

    private ProdutoDTO Produto;

    private Long qtdItem;

    private Double valorItem;

    private Double porcentoIcms;

    private Double valorIcms;
}
