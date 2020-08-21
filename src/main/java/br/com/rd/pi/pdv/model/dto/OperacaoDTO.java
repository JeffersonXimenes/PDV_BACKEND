package br.com.rd.pi.pdv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperacaoDTO {

    private Long cdOperacao;
    private Long tipoOperacao;
    private String descricaoOperacao;

}
