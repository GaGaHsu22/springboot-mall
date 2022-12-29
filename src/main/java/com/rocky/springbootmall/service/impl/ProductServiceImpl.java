package com.rocky.springbootmall.service.impl;

import com.rocky.springbootmall.dao.ProductDao;
import com.rocky.springbootmall.model.Product;
import com.rocky.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}