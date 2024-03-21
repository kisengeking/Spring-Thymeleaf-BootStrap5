package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.entity.Product;
import com.example.repository.ProductRepository;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String getProductsPage(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Product> products = productRepository.findAll(PageRequest.of(page, 10));
        model.addAttribute("products", products);
        model.addAttribute("currentPage", page);
        return "products";
    }
}
