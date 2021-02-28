package com.hrp.test;

import com.hrp.domain.Category;
import com.hrp.domain.Product;
import com.hrp.mapper.ProductMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author hrp
 * 2020/3/22 9:25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductTest {

    @Autowired
    private ProductMapper productMapper;

    @Test
    public void test() throws Exception {
        Product product = new Product();
        product.setName("男生短袖");
        product.setDesc("男生短袖，韩版修身，男士宽松潮流");
        product.setDate(new Date());
        product.setPrice(88.0);
        product.setStock(100);

        Category category = new Category();
        category.setId(8);
        product.setCategory(category);
        productMapper.saveProduct(product);
    }


}
