package br.com.rd.pi.pdv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentoFiscalDTO {

    private Long idDocumentoFiscal;

    private Long cdOperacao;

    private Long cdFilial;

    private Long idCliente;

    private Long idFornecedor;

    private Long idRecarga;

    private Date dataAbertura;

    private Date dataFechamento;

    private Integer flagNota;

    private Double valorDocumento;

    private Integer numeroCaixa;

//    private Long idMotivo;
//
//    private Long numeroNota;
//
//    private Long numeroChaveAcesso;
//
//    private Long numeroSerie;
//
//    private Date dataEmissao;
//
//    private Date dataEntrada;

}
