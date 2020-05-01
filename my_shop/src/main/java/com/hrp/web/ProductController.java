package com.hrp.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hrp.domain.Product;
import com.hrp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author hrp
 * 2020/3/21 21:23
 */
@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("page/{currentPage}")
    public ResponseEntity<IPage<Product>> findByPage(
            @PathVariable("currentPage") Integer currentPage,
            @RequestParam(defaultValue = "10") Integer size) throws Exception{
        return ResponseEntity.ok(productService.findByPage(currentPage,size));
    }

    @GetMapping("{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Integer id) throws Exception {
        return ResponseEntity.ok(productService.findById(id));
    }

    @GetMapping("todayhot")
    public ResponseEntity<List<Product>> findTodayhot() throws Exception{
        return ResponseEntity.ok(productService.findTodayHot());
    }

    @GetMapping("newarrival")
    public ResponseEntity<List<Product>> findNewarrival() throws Exception{
        return ResponseEntity.ok(productService.findNewarrival());
    }


    @PostMapping()
    public ResponseEntity<Void> saveProduct(@RequestBody Product product) throws Exception{
        productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @PutMapping()
    public ResponseEntity<Void> updateProduct(@RequestBody Product product) throws Exception{
        productService.updateProduct(product);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
