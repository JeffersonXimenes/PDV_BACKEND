package br.com.rd.pi.pdv.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperadorDTO {

    private Long idOperador;
    private String numeroMatricula;
    private String nomeOperador;
    private String descricaoCargo;
}
