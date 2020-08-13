package br.com.rd.pi.pdv.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_RECARGA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecargaEntity {

    @Id
    @Column(name = "ID_RECARGA")
    private Long idRecarga;

    @Column(name = "NR_TELEFONE")
    private String numeroTelefone;

    @Column(name ="VL_RECARGA")
    private double valorRecarga;

    @Column(name = "ID_OPERADORA")
    private Long idOperadora;

}
