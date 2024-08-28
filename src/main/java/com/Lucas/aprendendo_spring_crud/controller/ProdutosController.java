package com.Lucas.aprendendo_spring_crud.controller;

import com.Lucas.aprendendo_spring_crud.domain.product.Product;
import com.Lucas.aprendendo_spring_crud.domain.product.ProductRepository;
import com.Lucas.aprendendo_spring_crud.domain.product.RequestProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProdutosController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public ResponseEntity getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return ResponseEntity.ok(productList);
    }

    @PostMapping
    public ResponseEntity registerProduct(@RequestBody @Validated RequestProduct data) {
        Product product = new Product(data);
        System.out.println(data);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }
}
