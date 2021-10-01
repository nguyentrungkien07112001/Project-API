package com.vti.ki4m.mapper;

import com.vti.ki4m.dto.CategoryDTO;
import com.vti.ki4m.entity.Category;
import com.vti.ki4m.form.CategoryIn;
import com.vti.ki4m.form.CategoryUpdateIn;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public CategoryDTO map(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        return categoryDTO;
    }

    public Category map(CategoryIn categoryIn) {
        Category category = new Category();
        category.setName(categoryIn.getName());
        return category;
    }

    public Category map(CategoryUpdateIn categoryUpdateIn, Category category) {
        category.setName(categoryUpdateIn.getName());
        return category;
    }
}
