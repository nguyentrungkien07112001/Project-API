package com.vti.ki4m.controller;

import com.vti.ki4m.dto.CategoryDTO;
import com.vti.ki4m.form.CategoryIn;
import com.vti.ki4m.form.CategoryUpdateIn;
import com.vti.ki4m.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/category")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        List<CategoryDTO> categoryDTOS = categoryService.findAll();
        return new ResponseEntity<>(categoryDTOS, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CategoryIn categoryIn) {
        return new ResponseEntity<>(categoryService.create(categoryIn), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update (@PathVariable Integer id, @RequestBody CategoryUpdateIn categoryUpdateIn) {
        return new ResponseEntity<>(categoryService.update(id, categoryUpdateIn), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Integer id) {
        categoryService.delete(id);
        return new ResponseEntity<>("Delete success", HttpStatus.OK);
    }
}
