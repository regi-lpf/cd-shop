package br.com.devstoblu.cdshop.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import br.com.devstoblu.cdshop.dto.ProductDTO;
import br.com.devstoblu.cdshop.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);
    Product productDTOToProduct(ProductDTO productDTO);
    ProductDTO entityToDTO(Product product);
    List<ProductDTO> entitiesToDTOs(List<Product> product);
    Product dtoToEntity(ProductDTO productDTO);
}
