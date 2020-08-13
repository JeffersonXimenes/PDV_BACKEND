package br.com.rd.pi.pdv.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "TB_TIPO_PAGAMENTO")
@Data
public class TipoPagamentoEntity {

    @Id
    @Column(name = "ID_TIPO_PAGAMENTO")
    private Long idTipoPagamento;

    @Column(name = "DS_TIPO_PAGAMENTO")
    private String dsTipoPagamento;

}
