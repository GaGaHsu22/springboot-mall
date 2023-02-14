package com.rocky.springbootmall.service;

import com.rocky.springbootmall.dto.ProductRequest;
import com.rocky.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts();

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
    //update沒有返回值
    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
