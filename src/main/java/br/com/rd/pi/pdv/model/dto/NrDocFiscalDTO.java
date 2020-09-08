package br.com.rd.pi.pdv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class NrDocFiscalDTO {

    private Long proxNumFiscal;
    private FilialDTO filial;
}
