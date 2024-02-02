package com.simpleform.service;

import com.simpleform.model.BasketModel;
import com.simpleform.repository.BasketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {

    @Autowired
    private BasketRepository basketRepository;

    // sepete ekleme, sepeti görüntüleme, sepeti boşaltma gibi işlemler için service methodları tanımla

    // sepete bir ürün ekleme methodu
    public void addToBasket(BasketModel basket) {
        basketRepository.save(basket);
    }

    // sepete eklenen ürünleri listeleme methodu
    public List<BasketModel> getBasketByUserId(Integer userId) {
        return basketRepository.findByUsersTableId(userId);
    }

    // sepeti boşaltma methodu
    public void clearBasketByUserId(Integer userId) {
        basketRepository.deleteByUsersTableId(userId);
    }
}
