package com.hrp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.domain.Category;
import com.hrp.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hrp
 * 2020/3/21 10:03
 */
@RestController
@RequestMapping("category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("page/{currentPage}")
    public ResponseEntity<IPage<Category>> findByPage(
            @PathVariable("currentPage") Integer currentPage,
            @RequestParam(defaultValue = "10") Integer size) throws Exception{
        return ResponseEntity.ok(categoryService.findByPage(currentPage,size));
    }

    @GetMapping()
    public ResponseEntity<List<Category>> findAll() throws Exception {
        return ResponseEntity.ok(categoryService.findAll());
    }

    @GetMapping("parent")
    public ResponseEntity<List<Category>> findParentCategory() throws Exception {
        return ResponseEntity.ok(categoryService.findParentCategory());
    }

    @GetMapping("{id}")
    public ResponseEntity<Category> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(categoryService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Void> addCategory(@RequestBody Category category) throws Exception {
        categoryService.addCategory(category);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping()
    public ResponseEntity<Void> updateCategory(@RequestBody Category category) throws Exception{
        categoryService.updateCategory(category);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) throws Exception{
        categoryService.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
