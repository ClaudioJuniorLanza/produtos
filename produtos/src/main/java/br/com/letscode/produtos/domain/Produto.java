package br.com.letscode.produtos.domain;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    @GeneratedValue
    private Long id;
    private String nomeProduto;
    private String descricao;
    private Integer quantidade;
    private String modelo;
    private Double valorUnitario;
}
