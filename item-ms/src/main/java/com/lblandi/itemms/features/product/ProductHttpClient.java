package com.lblandi.itemms.features.product;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(
        name = "products-ms",
        url = "${products-ms.url}"
)
public interface ProductHttpClient {
    @GetMapping("/products")
    List<ProductDto> findAll();

    @GetMapping("/products/{id}")
    ProductDto findById(@PathVariable Long id);
}
