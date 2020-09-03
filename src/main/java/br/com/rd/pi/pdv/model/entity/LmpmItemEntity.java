package br.com.rd.pi.pdv.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_LMPM_ITEM")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LmpmItemEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LMPM_ITEM")
    private Long idLmpmItem;

    @ManyToOne
    @JoinColumn(name = "ID_LMPM")
    private LmpmEntity lmpm;

    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity produto;

    @Column(name = "QT_PRODUTO")
    private Long qtdProduto;

    @Column(name = "PC_DESCONTO")
    private Double pcDesconto;
}