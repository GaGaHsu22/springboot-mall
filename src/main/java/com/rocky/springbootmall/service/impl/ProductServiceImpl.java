package com.rocky.springbootmall.service.impl;

import com.rocky.springbootmall.dao.ProductDao;
import com.rocky.springbootmall.dto.ProductRequest;
import com.rocky.springbootmall.model.Product;
import com.rocky.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getProducts() {
        return productDao.getProducts();
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        //也是先預想會有這個function，接著再進到Dao層去新增與實作
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {

        productDao.updateProduct(productId,productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
