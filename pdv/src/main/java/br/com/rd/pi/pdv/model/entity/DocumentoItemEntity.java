package br.com.rd.pi.pdv.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_DOCUMENTO_FISCAL_ITEM")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoItemEntity {

    @Column(name = "ID_DOCUMENTO")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DOCUMENTO")
    @JsonIgnore
    @Id
    private Long idDocumento;

    @Id
    @Column(name = "NR_ITEM_DOCUMENTO")
    private Long numItemDoc;

//    @ManyToOne
    @Column(name = "CD_PRODUTO")
//    @JoinColumn(name = "CD_PRODUTO")
//    private ProdutoEntity cdProduto;
    private Long cdProduto;

    @Column (name = "QT_ITEM")
    private Long qtdItem;

    @Column (name = "PC_ICMS")
    private Double porcentoIcms;

    @Column (name = "VL_ICMS")
    private Double valorIcms;

    @Column (name = "VL_ITEM")
    private Double valorItem;

}
