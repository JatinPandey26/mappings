package com.jatinpandey.mappings.Controller;

import com.jatinpandey.mappings.DTOS.ProductDTO;
import com.jatinpandey.mappings.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/all")
    ResponseEntity<List<ProductDTO>> getAllProducts(){

        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping("/create")
    ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO){
        return new ResponseEntity<>(this.productService.createProduct(productDTO),HttpStatus.CREATED);
    }

    @PutMapping("/{product_id}/category/{category_id}")
    ResponseEntity<ProductDTO> mapProductToCategory(@PathVariable Long product_id , @PathVariable Long category_id){
        return new ResponseEntity<>(this.productService.assignToCategoryTOProduct(product_id,category_id),HttpStatus.OK);
    }
}
