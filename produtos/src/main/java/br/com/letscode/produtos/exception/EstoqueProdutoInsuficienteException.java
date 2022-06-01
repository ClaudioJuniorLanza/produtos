package br.com.letscode.produtos.exception;

import jakarta.validation.constraints.NotEmpty;

public class EstoqueProdutoInsuficienteException extends Throwable {
    public EstoqueProdutoInsuficienteException(@NotEmpty String nomeProduto) {
        super(String.format("Quantidade solicitade do produto %s é insuficiente no estoque!", nomeProduto));
    }
}
