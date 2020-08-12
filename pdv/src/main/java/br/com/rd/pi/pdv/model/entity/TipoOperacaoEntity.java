package br.com.rd.pi.pdv.model.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TipoOperacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_TIPO_OPERACAO")
    private Long idTipoOperacao;

    @Column(name = "DS_TIPO_OPERACAO")
    private String descricaoTipoOperacao;
}
