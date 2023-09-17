package com.jatinpandey.mappings.DTOS;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO {
    private Long id;

    private String name;
    List<ProductDTO> products = new ArrayList<>();

}
