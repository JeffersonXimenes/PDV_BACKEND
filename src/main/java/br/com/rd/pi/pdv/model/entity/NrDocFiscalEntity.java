package br.com.rd.pi.pdv.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_NR_DOC_FISCAL")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NrDocFiscalEntity implements Serializable {

    @Column(name = "CD_FILIAL")
    @JsonIgnore
    @Id
    private Long filial;

    @Column(name = "PROXIMO_NR_FISCAL")
    private Long proxNumFiscal;

}
