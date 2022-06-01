package br.com.letscode.produtos.exception;

import jakarta.validation.constraints.NotEmpty;

public class ProdutoEmptyException extends Throwable {
    public ProdutoEmptyException(@NotEmpty String nomeProduto) {
        super(String.format("Produto %s está vazio no estoque!", nomeProduto));
    }
}
