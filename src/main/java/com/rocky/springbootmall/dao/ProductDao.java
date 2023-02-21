package com.rocky.springbootmall.dao;

import com.rocky.springbootmall.constant.ProductCategory;
import com.rocky.springbootmall.dto.ProductQueryParams;
import com.rocky.springbootmall.dto.ProductRequest;
import com.rocky.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
