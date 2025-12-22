package com.lblandi.itemms.features.item;

import com.lblandi.itemms.features.product.ProductDto;

public record ItemModel(
        ProductDto product,
        int quantity
) {

    public Double getTotalPrice() {
        return product.price() * quantity;
    }

}
