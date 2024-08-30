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

    @GetMapping("/product")
    public ResponseEntity getAllProducts() {
        List<Product> productList = productRepository.findAll();
        return ResponseEntity.ok(productList);
    }

    @PostMapping("/product/item")
    public ResponseEntity registerProduct(@RequestBody @Validated RequestProduct data) {
        Product product = new Product(data);
        System.out.println(data);
        productRepository.save(product);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Validated RequestProduct data )  {
        Product product = productRepository.getReferenceById(data.id());
        product.setName(data.name());
        product.setPrice_in_cents(data.price_in_cents());
        return ResponseEntity.ok(product);
    }
}
