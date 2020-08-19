package br.com.rd.pi.pdv.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_PRODUTO")
@Data
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProdutoEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_PRODUTO")
    private Long cdProduto;

    @Column(name = "VL_UNIDADE")
    private Double valorProduto;

    @Column(name = "NM_FANTASIA")
    private String descricaoProduto;

}
