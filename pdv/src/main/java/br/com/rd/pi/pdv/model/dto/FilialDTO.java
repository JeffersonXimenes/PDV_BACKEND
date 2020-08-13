package br.com.rd.pi.pdv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilialDTO {

    private Long cdFilial;

    private String nmFilial;

    private String cnpj;

    private String nrTelefone;

}
