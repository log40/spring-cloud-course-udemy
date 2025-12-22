package com.lblandi.productms.features.product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> findAll();
    Optional<ProductEntity> findById(Long id);
}
