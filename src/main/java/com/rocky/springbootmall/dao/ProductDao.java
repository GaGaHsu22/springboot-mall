package com.rocky.springbootmall.dao;

import com.rocky.springbootmall.dto.ProductRequest;
import com.rocky.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
