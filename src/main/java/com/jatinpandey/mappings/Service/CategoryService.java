package com.jatinpandey.mappings.Service;

import com.jatinpandey.mappings.DTOS.CategoryDTO;
import com.jatinpandey.mappings.Entity.Category;
import com.jatinpandey.mappings.Mappers.CategoryMapper;
import com.jatinpandey.mappings.Repository.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryDTO createCategory(CategoryDTO categoryDTO){
        Category category = this.categoryMapper.toCategoryFromCategoryDTO(categoryDTO);

        return this.categoryMapper.toCategoryDTOFromCategory(this.categoryRepo.save(category));
    }
    public List<CategoryDTO> getAllCategories(){
        return this.categoryMapper.toCategoryDTOListFromCategoryDTOList(this.categoryRepo.findAll());
    }


}
