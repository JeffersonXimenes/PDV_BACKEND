package br.com.rd.pi.pdv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecargaDTO {

    private Long idRecarga;

    private String numeroTelefone;

    private double valorRecarga;

    private OperadoraDTO operadora;

    //@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<OperadoraDTO> items;
}

