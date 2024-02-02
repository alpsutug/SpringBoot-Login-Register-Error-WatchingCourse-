package com.simpleform.service;

import com.simpleform.model.ProductModel;
import com.simpleform.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // ürün ekleme, ürün silme, ürün güncelleme, ürün listeleme gibi işlemler için service methodları tanımla

    // ürün ekleme methodu
    public void addProduct(ProductModel product) {
        productRepository.save(product);
    }

    // ürün silme methodu
    public void deleteProduct(Integer id) {
        productRepository.deleteById(id);
    }

    // ürün güncelleme methodu
    public void updateProduct(ProductModel product) {
        productRepository.save(product);
    }

    // ürün listeleme methodu
    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }

    // ürün id'sine göre ürün bulma methodu
    public Optional<ProductModel> getProductById(Integer id) {
        return productRepository.findById(id);
    }
}
