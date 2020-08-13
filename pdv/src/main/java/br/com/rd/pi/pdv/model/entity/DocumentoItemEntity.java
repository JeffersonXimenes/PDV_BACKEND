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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DOCUMENTO")
    @JsonIgnore
    @Id
    private DocumentoFiscalEntity documentoFiscal;

    @Id
    @Column(name = "NR_ITEM_DOCUMENTO")
    private Long numItemDoc;

    @ManyToOne
    @JoinColumn(name = "CD_PRODUTO")
    private ProdutoEntity cdProduto;

    @Column (name = "QT_ITEM")
    private Long qtdItem;

    @Column (name = "PC_ICMS")
    private Double porcentoIcms;

    @Column (name = "VL_ICMS")
    private Double valorIcms;

    @Column (name = "VL_ITEM")
    private Double valorItem;

}
