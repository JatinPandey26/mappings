package com.jatinpandey.mappings.DTOS;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    List<CategoryDTO> categories = new ArrayList<>();
}
