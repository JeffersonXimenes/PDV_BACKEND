package br.com.rd.pi.pdv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperadoraDTO {

    private Long idOperadora;

    private String descricaoOperadora;
}
