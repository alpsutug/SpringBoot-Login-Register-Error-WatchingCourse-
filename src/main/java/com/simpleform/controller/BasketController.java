package com.simpleform.controller;

import com.simpleform.model.BasketModel;
import com.simpleform.model.ProductModel;
import com.simpleform.model.UsersModel;
import com.simpleform.repository.BasketRepository;
import com.simpleform.repository.ProductRepository;
import com.simpleform.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class BasketController {

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "/basket", method = RequestMethod.GET) //@GetMapping("/basket")
    public String addToBasket(@RequestParam("productId") Integer productId, @RequestParam("userId") Integer userId, Model model) {
        // burada sepete ekleme işlemlerini yap
        ProductModel product = productRepository.findById(productId).orElse(null);
        UsersModel user = usersRepository.findById(userId).orElse(null);
        BasketModel basket = new BasketModel();
        basket.setUsersTableId(user.getId());
        basket.setProductTableId(product.getId());
        basket.setBasketAmount(1); // varsayılan olarak sepete 1 adet ekliyoruz, istersen değiştirebilirsin
        basket.setOrderDate(new Timestamp(System.currentTimeMillis())); // sipariş tarihini şimdiki zaman olarak ayarlıyoruz
        basketRepository.save(basket);

        List<BasketModel> basketList = basketRepository.findByUsersTableId(userId); // sepete eklenen ürünlerin listesini bul
        int totalPrice = 0; // toplam fiyatı hesaplamak için bir değişken tanımla
        for (BasketModel b : basketList) {
            ProductModel p = productRepository.findById(b.getProductTableId()).orElse(null); // her sepet elemanı için ilgili ürünü bul
            totalPrice += p.getProductPrice() * b.getBasketAmount(); // toplam fiyata ürün fiyatı ile sepet miktarını çarpıp ekle
        }
        model.addAttribute("basketList", basketList); // sepet listesini model'e ekle
        model.addAttribute("totalPrice", totalPrice); // toplam fiyatı model'e ekle
        model.addAttribute("username", user.getLogin()); // kullanıcı adını model'e ekle
        return "basket";
    }
}
