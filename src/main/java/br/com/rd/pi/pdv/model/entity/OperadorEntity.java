package br.com.rd.pi.pdv.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_OPERADOR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperadorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OPERADOR")
    private Long idOperador;

    @Column(name = "NR_MATRICULA")
    private String numeroMatricula;

    @Column(name = "NM_NOME")
    private String nomeOperador;

    @Column(name = "DS_CARGO")
    private String descricaoCargo;
}