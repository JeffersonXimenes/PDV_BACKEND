package br.com.rd.pi.pdv.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "TB_TIPO_OPERACAO")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoOperacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_OPERACAO")
    private Long idTipoOperacao;

    @Column(name = "DS_TIPO_OPERACAO")
    private String descricaoTipoOperacao;
}
