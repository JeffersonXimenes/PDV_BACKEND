package br.com.rd.pi.pdv.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "TB_PRODUTO_FILIAL_ESTOQUE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EstoqueEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_ESTOQUE")
    private Long cdEstoque;

    @ManyToOne
    @JoinColumn(name = "CD_FILIAL")
    private FilialEntity filial;

    @ManyToOne
    @JoinColumn(name ="CD_PRODUTO")
    private ProdutoEntity produto;

    @Column(name = "QT_ESTOQUE")
    private Long qtdEstoque;

    @Column(name = "QT_EMPENHO")
    private Long qtdEmpenho;
}
