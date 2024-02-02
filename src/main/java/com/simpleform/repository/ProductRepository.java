package com.simpleform.repository;

import com.simpleform.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {

    // ürün id'sine göre ürünü bulmak için bir method tanımla
    Optional<ProductModel> findById(Integer id);
}
