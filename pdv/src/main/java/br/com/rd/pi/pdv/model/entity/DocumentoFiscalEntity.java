package br.com.rd.pi.pdv.model.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "TB_DOCUMENTO_FISCAL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocumentoFiscalEntity {

    @Id
    @GeneratedValue
    @Column(name = "ID_DOCUMENTO_FISCAL")
    private Long idDocumentoFiscal;

    @JoinColumn(name = "CD_OPERACAO")
    @ManyToOne
    private OperacaoEntity cdOperacao;


    //@JoinColumn(name = "CD_FILIAL")
    //private FilialEntity cdFilial;

    @Column(name = "CD_FILIAL")
    private Long cdFilial;


    @Column(name = "ID_CLIENTE")
    @JoinColumn(name = "ID_CLIENTE")
//    private ClienteEntity idCliente;
    private Long idCliente;

    //@JoinColumn(name = "ID_RECARGA")
    @Column(name = "ID_RECARGA")
    //private RecargaEntity idRecarga;
    private Long idRecarga;

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

    @OneToMany
    @JoinColumn(name = "ID_NF")
    private List<DocumentoItemEntity> itens;

    //campos do doc fiscal que nao sabemos se iremos utilizar
//    @Column(name = "ID_FORNECEDOR")
//    private Long idFornecedor;

//    @Column(name = "ID_MOTIVO")
//    private Long idMotivo;

//    @Column(name = "NR_NF")
//    private Long numeroNota;
//
//    @Column(name = "NR_CHAVE_ACESSO")
//    private Long numeroChaveAcesso;
//
//    @Column(name = "NR_SERIE")
//    private Long numeroSerie;
//
//    @Column(name = "DT_EMISSAO")
//    private Date dataEmissao;

//    @Column(name = "DT_ENTRADA")
//    private Date dataEntrada;



}
