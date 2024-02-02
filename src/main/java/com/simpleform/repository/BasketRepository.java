package com.simpleform.repository;

import com.simpleform.model.BasketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends JpaRepository<BasketModel, Integer> {

    // kullanıcı id'sine göre sepete eklenen ürünleri bulmak için bir method tanımla
    List<BasketModel> findByUsersTableId(Integer usersTableId);

    void deleteByUsersTableId(Integer userId);
}
