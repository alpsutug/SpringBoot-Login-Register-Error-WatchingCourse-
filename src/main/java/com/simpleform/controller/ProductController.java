package com.simpleform.controller;

import com.simpleform.model.ProductModel;
import com.simpleform.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    // ürün ekleme işlemi için bir get request handler methodu
    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        // boş bir product entity'si oluştur
        ProductModel product = new ProductModel();
        // product entity'sini model'e ekle
        model.addAttribute("product", product);
        // ürün ekleme formunun view adını return et
        return "add_product";
    }

    // ürün ekleme işlemi için bir post request handler methodu
    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("product") ProductModel product) {
        // product service'i kullanarak product entity'sini veri tabanına kaydet
        productService.addProduct(product);
        // ürün listeleme sayfasına yönlendir
        return "redirect:/listProducts";
    }

    // ürün silme işlemi için bir get request handler methodu
    @GetMapping("/deleteProduct/{id}")
    public String deleteProduct(@PathVariable(value = "id") Integer id) {
        // product service'i kullanarak verilen id'ye sahip ürünü veri tabanından sil
        productService.deleteProduct(id);
        // ürün listeleme sayfasına yönlendir
        return "redirect:/listProducts";
    }

    // ürün güncelleme işlemi için bir get request handler methodu
    @GetMapping("/updateProduct/{id}")
    public String showUpdateProductForm(@PathVariable(value = "id") Integer id, Model model) {
        // product service'i kullanarak verilen id'ye sahip ürünü veri tabanından bul
        Optional<ProductModel> product = productService.getProductById(id);
        // product entity'sini model'e ekle
        model.addAttribute("product", product);
        // ürün güncelleme formunun view adını return et
        return "update_product";
    }

    // ürün güncelleme işlemi için bir post request handler methodu
    @PostMapping("/updateProduct")
    public String updateProduct(@ModelAttribute("product") ProductModel product) {
        // product service'i kullanarak product entity'sini veri tabanında güncelle
        productService.updateProduct(product);
        // ürün listeleme sayfasına yönlendir
        return "redirect:/listProducts";
    }

    // ürün listeleme işlemi için bir get request handler methodu
    @GetMapping("/listProducts")
    public String listProducts(Model model) {
        // product service'i kullanarak tüm ürünleri veri tabanından getir
        List<ProductModel> productList = productService.getAllProducts();
        // product listesini model'e ekle
        model.addAttribute("productList", productList);
        // ürün listeleme sayfasının view adını return et
        return "list_products";
    }
}
