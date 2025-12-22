package com.lblandi.productms.features.product;

import java.io.Serial;

public class ProductNotFoundException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;

    public ProductNotFoundException(Long id) {
        super("Product with id '%s' was not found...".formatted(id));
    }
}
