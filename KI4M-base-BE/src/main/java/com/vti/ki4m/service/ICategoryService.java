package com.vti.ki4m.service;

import com.vti.ki4m.dto.CategoryDTO;
import com.vti.ki4m.entity.Category;
import com.vti.ki4m.form.CategoryIn;
import com.vti.ki4m.form.CategoryUpdateIn;

import java.util.List;

public interface ICategoryService {

    List<CategoryDTO> findAll();

    Category create (CategoryIn categoryIn);

    Category update (Integer id, CategoryUpdateIn categoryUpdateIn);

    void delete (Integer id);
}
