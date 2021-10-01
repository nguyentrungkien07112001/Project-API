package com.vti.ki4m.service.serviceImpl;

import com.vti.ki4m.dto.CategoryDTO;
import com.vti.ki4m.entity.Category;
import com.vti.ki4m.form.CategoryIn;
import com.vti.ki4m.form.CategoryUpdateIn;
import com.vti.ki4m.mapper.CategoryMapper;
import com.vti.ki4m.repository.ICategoryRepository;
import com.vti.ki4m.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoryDTOS = categories.stream().map(it -> categoryMapper.map(it)).collect(Collectors.toList());
        return categoryDTOS;
    }

    @Override
    public Category create(CategoryIn categoryIn) {
        Category category = categoryMapper.map(categoryIn);
        Category response = categoryRepository.save(category);
        return response;
    }

    @Override
    public Category update(Integer id, CategoryUpdateIn categoryUpdateIn) {
        Category category = categoryRepository.findCategoryById(id);
        categoryMapper.map(categoryUpdateIn, category);
        Category response = categoryRepository.save(category);
        return response;
    }

    @Override
    public void delete(Integer id) {
        Category category = categoryRepository.findCategoryById(id);
        categoryRepository.delete(category);
    }
}
