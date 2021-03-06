package br.com.rd.pi.pdv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PagamentoDocDTO {

    private Long idPagamento;
    private DocumentoFiscalDTO documentoFiscal;
    private Double vlPagamento;
    private TipoPagamentoDTO tipoPagamento;

}