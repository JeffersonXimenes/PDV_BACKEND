package br.com.rd.pi.pdv.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_CLIENTE")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CLIENTE")
    private Long idCliente;

    @Column(name = "NR_CPF")
    private String numeroCpf;

    @Column(name = "DS_EMAIL")
    private String email;

}
