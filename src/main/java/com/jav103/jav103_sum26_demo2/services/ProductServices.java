package com.jav103.jav103_sum26_demo2.services;


import com.jav103.jav103_sum26_demo2.entity.Product;
import com.jav103.jav103_sum26_demo2.repository.ProductRepository;

import java.util.List;

public class ProductServices {
    private final ProductRepository productRepository = new ProductRepository();

    public List<Product> getProducts() {
        return productRepository.getAllProduct();
    }

    public void deleteProduct(Long id) {
        productRepository.deleteProduct(id);
    }

    public Product getProductById(Long id) {
        return productRepository.getProductById(id);
    }

    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }

    public void editProduct(Product product) {
        productRepository.editProduct(product);
    }
}
