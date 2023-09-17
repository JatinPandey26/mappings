package com.jatinpandey.mappings.Mappers;

import com.jatinpandey.mappings.DTOS.CategoryDTO;
import com.jatinpandey.mappings.Entity.Category;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {ProductMapper.class})
public interface CategoryMapper {

    Category toCategoryFromCategoryDTO(CategoryDTO categoryDTO);

    CategoryDTO toCategoryDTOFromCategory(Category category);

    List<Category> toCategoryListFromCategoryDTOList(List<CategoryDTO> categoryDTOS);

    List<CategoryDTO> toCategoryDTOListFromCategoryDTOList(List<Category> categories);

}
