package br.com.rd.pi.pdv.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "TB_OPERADORA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperadoraEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_OPERADORA")
    private Long idOperadora;

    @Column(name ="DS_OPERADORA")
    private String descricaoOperadora;
}
