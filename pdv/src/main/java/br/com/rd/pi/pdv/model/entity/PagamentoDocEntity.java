package br.com.rd.pi.pdv.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "TB_PAGAMENTO_DOC")
@Data
public class PagamentoDocEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PAGAMENTO")
    private Long idPagamento;

    @Column(name = "ID_DOCUMENTO_FISCAL")
    private Long idDocumentoFiscal;

    @Column(name = "VL_PAGAMENTO")
    private Double vlPagamento;

    @ManyToOne
    @JoinColumn(name = "ID_TIPO_PAGAMENTO")
    private TipoPagamentoEntity tipoPagamento;

}