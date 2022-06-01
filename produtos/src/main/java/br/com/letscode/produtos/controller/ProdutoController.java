package br.com.letscode.produtos.controller;

import br.com.letscode.produtos.dto.request.ProdutoDTO;
import br.com.letscode.produtos.dto.request.ProdutoPatch;
import br.com.letscode.produtos.dto.response.ProdutoResponse;
import br.com.letscode.produtos.exception.EstoqueProdutoInsuficienteException;
import br.com.letscode.produtos.exception.ProdutoEmptyException;
import br.com.letscode.produtos.exception.ProdutoNotFoundException;
import br.com.letscode.produtos.service.ProdutoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/produtos", produces = "application/json")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoController {

    private final ProdutoService produtoService;

    @GetMapping("/{id}")
    public Optional<ProdutoResponse> findById(@PathVariable Long id) throws ProdutoNotFoundException {
      return produtoService.findById(id);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoDTO> listAll(){
        return produtoService.listAll();
    }

    @PostMapping
    public ProdutoResponse create(@RequestBody ProdutoDTO produtoDTO){
        return produtoService.save(produtoDTO);
    }

    @PatchMapping
    public String atualizaEstoque(@RequestBody List<ProdutoPatch> listProdutoPatch) throws ProdutoNotFoundException, ProdutoEmptyException, EstoqueProdutoInsuficienteException {
        return produtoService.atualizaEstoque(listProdutoPatch);
    }

}
