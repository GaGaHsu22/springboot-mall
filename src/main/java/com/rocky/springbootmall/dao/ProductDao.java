package com.rocky.springbootmall.dao;

import com.rocky.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
