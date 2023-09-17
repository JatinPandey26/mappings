package com.jatinpandey.mappings.Service;

import com.jatinpandey.mappings.DTOS.ProductDTO;
import com.jatinpandey.mappings.Entity.Category;
import com.jatinpandey.mappings.Entity.Product;
import com.jatinpandey.mappings.Exceptions.ResourceNotFoundException;
import com.jatinpandey.mappings.Mappers.ProductMapper;
import com.jatinpandey.mappings.Repository.CategoryRepo;
import com.jatinpandey.mappings.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepo productRepo;

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ProductMapper productMapper;

    public ProductDTO createProduct(ProductDTO productDTO){
        Product product = productMapper.toProductFromProductDTO(productDTO);
        return  this.productMapper.toProductDTOFromProduct(this.productRepo.save(product));
    }

    public ProductDTO assignToCategoryTOProduct(Long product_id , Long category_id){

        Product product = this.productRepo.findById(product_id).orElseThrow(() -> new ResourceNotFoundException("Product","id",product_id));
        Category category = this.categoryRepo.findById(category_id).orElseThrow(() -> new ResourceNotFoundException("Category","id",category_id));

        List<Category> categoryList = product.getCategories();

        categoryList.add(category);

        product.setCategories(categoryList);

        return  this.productMapper.toProductDTOFromProduct(this.productRepo.save(product));
    }

    public List<ProductDTO> getAllProducts(){
        return this.productMapper.toProductDTOListFromProductList(this.productRepo.findAll());
    }

}
