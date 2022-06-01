package br.com.letscode.produtos.dto.mapper;

import br.com.letscode.produtos.domain.Produto;
import br.com.letscode.produtos.dto.request.ProdutoDTO;
import br.com.letscode.produtos.dto.response.ProdutoResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    Produto toModel(ProdutoDTO produtoDTO);

    ProdutoResponse toResponse(Produto produto);

    ProdutoDTO toDTO(Produto produto);
}
