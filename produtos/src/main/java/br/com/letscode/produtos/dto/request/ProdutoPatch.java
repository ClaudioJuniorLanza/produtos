package br.com.letscode.produtos.dto.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoPatch {

    @NotEmpty
    private Long id;
    @NotEmpty
    private Integer quantidade;

}
