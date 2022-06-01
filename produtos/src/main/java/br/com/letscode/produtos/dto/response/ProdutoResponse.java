package br.com.letscode.produtos.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoResponse {

    private Long idProduto;
    private String nomeProduto;
    private Integer quantidade;
    private Double valorUnitario;
}
