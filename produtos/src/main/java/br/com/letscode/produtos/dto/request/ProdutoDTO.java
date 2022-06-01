package br.com.letscode.produtos.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    private Long id;

    @NotEmpty
    private String nomeProduto;
    @NotEmpty
    private String descricao;
    @NotEmpty
    private Integer quantidade;
    @NotEmpty
    private String modelo;
    @NotEmpty
    private Double valorUnitario;
    @Valid
    private MarcaDTO marca;
}
