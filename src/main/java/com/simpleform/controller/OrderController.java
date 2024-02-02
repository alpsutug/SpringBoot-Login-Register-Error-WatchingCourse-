package com.simpleform.controller;

import com.simpleform.model.BasketModel;
import com.simpleform.model.OrderModel;
import com.simpleform.model.ProductModel;
import com.simpleform.repository.BasketRepository;
import com.simpleform.repository.OrderRepository;
import com.simpleform.repository.ProductRepository;
import com.simpleform.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BasketRepository basketRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UsersRepository usersRepository;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public String order(@RequestParam("userId") Integer userId, Model model) {
        // burada sipariş işlemlerini yap
        List<BasketModel> basketList = basketRepository.findByUsersTableId(userId); // sepete eklenen ürünlerin listesini bul
        for (BasketModel b : basketList) {
            OrderModel order = new OrderModel(); // yeni bir order entity'si oluştur
            order.setUsersTableId(b.getUsersTableId()); // order entity'sinin usersTableId alanını basket entity'sinin usersTableId alanı ile doldur
            order.setProductTableId(b.getProductTableId()); // order entity'sinin productTableId alanını basket entity'sinin productTableId alanı ile doldur
            order.setOrderAmount(b.getBasketAmount()); // order entity'sinin orderAmount alanını basket entity'sinin basketAmount alanı ile doldur
            order.setOrderDate(b.getOrderDate()); // order entity'sinin orderDate alanını basket entity'sinin orderDate alanı ile doldur
            orderRepository.save(order); // order entity'sini order repository'ye save et
        }

        List<OrderModel> orderList = orderRepository.findByUsersTableId(userId); // sipariş edilen ürünlerin listesini bul
        int totalPrice = 0; // toplam fiyatı hesaplamak için bir değişken tanımla
        for (OrderModel o : orderList) {
            ProductModel p = productRepository.findById(o.getProductTableId()).orElse(null); // her sipariş elemanı için ilgili ürünü bul
            totalPrice += p.getProductPrice() * o.getOrderAmount(); // toplam fiyata ürün fiyatı ile sipariş miktarını çarpıp ekle
        }
        model.addAttribute("orderList", orderList); // sipariş listesini model'e ekle
        model.addAttribute("totalPrice", totalPrice); // toplam fiyatı model'e ekle
      //  model.addAttribute("username", .findByLoginAndPassword()); // kullanıcı adını model'e ekle
        return "order";
    }
}
