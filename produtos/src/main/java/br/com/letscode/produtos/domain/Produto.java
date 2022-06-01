package br.com.letscode.produtos.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nomeProduto;
    @Column
    private String descricao;
    @Column
    private Integer quantidade;
    @Column
    private String modelo;
    @Column
    private Double valorUnitario;
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Marca marca;
}
