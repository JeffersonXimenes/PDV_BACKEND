package br.com.rd.pi.pdv.model.entity;

import br.com.rd.pi.pdv.model.dto.OperadoraDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

import java.util.List;

@Entity
@Table(name = "TB_RECARGA")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@NamedQuery(name = "buscarDsOperadora", query = "SELECT RE FROM RecargaEntity RE where RE.operadora.IdOperadora =: idOperadora")
public class RecargaEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_RECARGA")
    private Long idRecarga;

    @Column(name = "NR_TELEFONE")
    private String numeroTelefone;

    @Column(name ="VL_RECARGA")
    private double valorRecarga;

    @ManyToOne
    @JoinColumn(name = "ID_OPERADORA")
    private OperadoraEntity operadora;


    //@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    //private List<OperadoraEntity> itensRecargas;

}