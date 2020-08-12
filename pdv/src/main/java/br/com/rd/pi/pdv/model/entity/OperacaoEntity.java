package br.com.rd.pi.pdv.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_OPERACAO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_OPERACAO")
    private Long cdOperacao;

    @Column(name = "ID_TIPO_OPERACAO")
    private Long idTipoOperacao;

    @Column(name = "DS_OPERACAO")
    private String descricaoOperacao;

}
