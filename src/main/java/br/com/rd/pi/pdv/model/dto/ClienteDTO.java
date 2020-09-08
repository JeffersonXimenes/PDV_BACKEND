package br.com.rd.pi.pdv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteDTO {

    private Long idCliente;
    private String numeroCpf;
    private String email;
    private Long idCategoriaCliente = 1L;
}
