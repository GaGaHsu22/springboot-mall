package com.rocky.springbootmall.service;

import com.rocky.springbootmall.dto.ProductRequest;
import com.rocky.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
    //update沒有返回值
    void updateProduct(Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
