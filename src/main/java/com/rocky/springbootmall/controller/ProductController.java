package com.rocky.springbootmall.controller;

import com.rocky.springbootmall.dto.ProductRequest;
import com.rocky.springbootmall.model.Product;
import com.rocky.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> productList = productService.getProducts();
        return ResponseEntity.status(HttpStatus.OK).body(productList);
    }

    @GetMapping("products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId){
        Product product = productService.getProductById(productId);
        if(product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {
        //實作新增商品功能 由 controller 寫回 dao
        //可先建立預期的方法，此時createProduct還沒新建(只是預想會有)，所以會是紅色的
        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){
        Product product = productService.getProductById(productId);
        //先查詢商品是否存在
        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //修改商品數據
        //一路從controller層實作進去
        productService.updateProduct(productId,productRequest);

        Product updatedProduct = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId){
        productService.deleteProductById(productId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}