package br.com.rd.pi.pdv.model.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueDTO {

    private Long cdEstoque;

    private FilialDTO filial;

    private ProdutoDTO produto;

    private Long qtEstoque;

    private Long qtEmpenho;

}
