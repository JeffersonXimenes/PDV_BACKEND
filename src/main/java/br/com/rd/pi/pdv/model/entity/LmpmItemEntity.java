package br.com.rd.pi.pdv.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_LMPM_ITEM")
@Data
public class LmpmItemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LMPM_ITEM")
    private Long idLmpmItem;

    @ManyToOne
    @JoinColumn(name = "ID_LMPM")
    private LmpmEntity lmpm;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity produto;

    @Column(name = "QT_PRODUTO")
    private Long qtdProduto;

    @Column(name = "PC_DESCONTO")
    private Double pcDesconto;
}