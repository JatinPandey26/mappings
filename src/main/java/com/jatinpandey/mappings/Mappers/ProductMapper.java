package com.jatinpandey.mappings.Mappers;

import com.jatinpandey.mappings.DTOS.ProductDTO;
import com.jatinpandey.mappings.Entity.Product;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = {CategoryMapper.class})
public interface ProductMapper {
    @Mapping(target = "categories" , source = "categories" ,ignore = true)
    Product toProductFromProductDTO(ProductDTO productDTO);
    @Mapping(target = "categories" , source = "categories" ,ignore = true)
    ProductDTO toProductDTOFromProduct(Product product);

    List<Product> toProductListFromProductDTOList(List<ProductDTO> productDTOS);
    List<ProductDTO> toProductDTOListFromProductList(List<Product> products);
}
