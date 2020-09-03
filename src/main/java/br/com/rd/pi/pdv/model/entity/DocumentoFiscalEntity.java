package br.com.rd.pi.pdv.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_DOCUMENTO_FISCAL")
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "buscarNotaPorOperacao",
        query = "SELECT doc FROM DocumentoFiscalEntity doc where doc.operacao.cdOperacao =: operacao")
public class DocumentoFiscalEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DOCUMENTO_FISCAL")
    private Long idDocumentoFiscal;

    @ManyToOne
    @JoinColumn(name = "CD_OPERACAO")
    private OperacaoEntity operacao;

    @ManyToOne
    @JoinColumn(name = "CD_FILIAL")
    private FilialEntity filial;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private ClienteEntity cliente;

    @ManyToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name = "ID_RECARGA")
    private RecargaEntity recarga;

    @Column(name = "DT_ABERTURA")
    private Date dataAbertura;

    @Column(name = "DT_FECHAMENTO")
    private Date dataFechamento;

    @Column(name = "FL_NF")
    private Integer flagNota;

    @Column(name = "VL_DOCUMENTO_FISCAL")
    private Double valorDocumento;

    @Column(name = "NR_CAIXA")
    private Integer numeroCaixa;

    @OneToMany (mappedBy = "documentoFiscal",cascade = CascadeType.ALL)
    private List<DocumentoItemEntity> itens;

    @OneToMany (mappedBy = "documentoFiscal",cascade = CascadeType.ALL)
    private List<PagamentoDocEntity> pagamentos;
}
