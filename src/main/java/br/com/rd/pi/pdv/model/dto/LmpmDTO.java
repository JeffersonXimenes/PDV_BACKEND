package br.com.rd.pi.pdv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LmpmDTO {

    private Long idLmpm;
    private Date dtInicioLmpm;
    private Date dtFimLmpm;
}