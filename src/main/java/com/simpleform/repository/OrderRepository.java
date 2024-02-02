package com.simpleform.repository;

import com.simpleform.model.OrderModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderModel, Integer> {

    // kullanıcı id'sine göre sipariş edilen ürünleri bulmak için bir method tanımla
    List<OrderModel> findByUsersTableId(Integer usersTableId);
}
