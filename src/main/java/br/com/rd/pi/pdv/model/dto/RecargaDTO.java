package br.com.rd.pi.pdv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecargaDTO {

    private Long idRecarga;

    private String numeroTelefone;

    private double valorRecarga;

    private Long idOperadora;
}
