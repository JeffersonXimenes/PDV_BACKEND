package br.com.rd.pi.pdv.model.dto;

import br.com.rd.pi.pdv.model.entity.PagamentoDocEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class DocumentoFiscalDTO {

    private Long idDocumentoFiscal;

    private OperacaoDTO operacao;

    private FilialDTO filial;

    private ClienteDTO cliente;

    private RecargaDTO recarga;

    private Date dataAbertura;

    private Date dataFechamento;

    private Integer flagNota;

    private Double valorDocumento;

    private Integer numeroCaixa;

    private Long numeroNota;

    private List<DocumentoItemDTO> itens;

    private List<PagamentoDocDTO> pagamentos;
}
