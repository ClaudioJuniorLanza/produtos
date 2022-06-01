package br.com.letscode.produtos.service;

import br.com.letscode.produtos.domain.Produto;
import br.com.letscode.produtos.dto.mapper.ProdutoMapper;
import br.com.letscode.produtos.dto.request.ProdutoDTO;
import br.com.letscode.produtos.dto.request.ProdutoPatch;
import br.com.letscode.produtos.dto.response.ProdutoResponse;
import br.com.letscode.produtos.exception.EstoqueProdutoInsuficienteException;
import br.com.letscode.produtos.exception.ProdutoEmptyException;
import br.com.letscode.produtos.exception.ProdutoNotFoundException;
import br.com.letscode.produtos.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper = ProdutoMapper.INSTANCE;

    public Optional<ProdutoResponse> findById(Long id) throws ProdutoNotFoundException {
        return Optional.ofNullable(produtoRepository.findById(id)
                .map(produtoMapper::toResponse)
                .orElseThrow( () -> new ProdutoNotFoundException(id)));
    }

    public List<ProdutoResponse> listAll(){
        return produtoRepository.findAll()
                .stream()
                .map(produtoMapper::toResponse)
                .collect(Collectors.toList());
    }

    public ProdutoResponse save(ProdutoDTO produtoDTO){
        Produto produtoConverter = produtoMapper.toModel(produtoDTO);
        Produto produtoCreated = produtoRepository.save(produtoConverter);
        return produtoMapper.toResponse(produtoCreated);
    }

    public String atualizaEstoque(List<ProdutoPatch> listProdutosPatch) throws ProdutoNotFoundException, ProdutoEmptyException, EstoqueProdutoInsuficienteException {
        for (ProdutoPatch produtoPatch: listProdutosPatch) {
            ProdutoDTO produtoDTO = verifyIsExistsProduto(produtoPatch.getIdProduto());
            validaCompra(produtoDTO, produtoPatch);
            int quantidadeAtualizada = produtoDTO.getQuantidade() - produtoPatch.getQuantidade();
            produtoDTO.setQuantidade(quantidadeAtualizada);
            Produto produto = produtoMapper.toModel(produtoDTO);
            produtoRepository.save(produto);
        }
        return "Estoque atualizado com sucesso!";
    }

    private ProdutoDTO verifyIsExistsProduto(Long idProduto) throws ProdutoNotFoundException {
        return produtoRepository.findById(idProduto)
                .map(produtoMapper::toDTO)
                .orElseThrow( () -> new ProdutoNotFoundException(idProduto));
    }

    private void validaCompra(ProdutoDTO produtoDTO, ProdutoPatch produtoPatch) throws ProdutoEmptyException, EstoqueProdutoInsuficienteException {
        if(produtoDTO.getQuantidade() == 0){
            throw new ProdutoEmptyException(produtoDTO.getNomeProduto());
        }

        int saldoQuantidade = produtoDTO.getQuantidade() - produtoPatch.getQuantidade();

        if(saldoQuantidade <= 0){
            throw new EstoqueProdutoInsuficienteException(produtoDTO.getNomeProduto());
        }
    }

}
