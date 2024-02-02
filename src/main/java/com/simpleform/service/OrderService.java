package com.simpleform.service;

import com.simpleform.model.OrderModel;
import com.simpleform.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // sipariş verme, sipariş iptal etme, sipariş görüntüleme gibi işlemler için service methodları tanımla

    // sipariş verme methodu
    public void order(OrderModel order) {
        orderRepository.save(order);
    }

    // sipariş iptal etme methodu
    public void cancelOrder(Integer id) {
        orderRepository.deleteById(id);
    }

    // sipariş görüntüleme methodu
    public List<OrderModel> getOrderByUserId(Integer userId) {
        return orderRepository.findByUsersTableId(userId);
    }
}
