package br.com.rd.pi.pdv.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


import java.util.List;


@Entity
@Table(name = "TB_OPERADORA")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class OperadoraEntity implements Serializable {

    @Id
    //@OneToMany(mappedBy = "Operadora", cascade = CascadeType.ALL)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_OPERADORA")
    private Long idOperadora;


    @Column(name ="DS_OPERADORA")
    private String descricaoOperadora;

    //private RecargaEntity operadora;
    //private RecargaEntity items;

}