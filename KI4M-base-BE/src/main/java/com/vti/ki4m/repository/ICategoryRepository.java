package com.vti.ki4m.repository;

import com.vti.ki4m.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    Category findCategoryById(Integer id);
}
