package com.lblandi.productms.features.product;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> findAll() {
        return ResponseEntity.status(200).body(productService.findAll());
    }

    @GetMapping("/{product_id}")
    public ResponseEntity<ProductEntity> findById(@PathVariable("product_id") Long productId) {
        return ResponseEntity.status(200)
                .body(productService.findById(productId).orElse(null));
    }
}

