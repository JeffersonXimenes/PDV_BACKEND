package br.com.rd.pi.pdv.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LmpmItemDTO {

    private Long idLmpmItem;
    private Long qtdProduto;
    private Double pcDesconto;
    private LmpmDTO lmpm;
    private ProdutoDTO produto;
}