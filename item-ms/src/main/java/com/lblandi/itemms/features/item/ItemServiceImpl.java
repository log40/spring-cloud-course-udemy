package com.lblandi.itemms.features.item;

import com.lblandi.itemms.features.product.ProductDto;
import com.lblandi.itemms.features.product.ProductHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Service
public class ItemServiceImpl implements ItemService {
    private static final Logger log = LoggerFactory.getLogger(ItemServiceImpl.class);
    private final ProductHttpClient productClient;
    private final Random random;

    public ItemServiceImpl(ProductHttpClient productClient) {
        this.productClient = productClient;
        this.random = new Random();
    }

    @Override
    public List<ItemModel> findAll() {
        log.info("Fetching products from products-ms...");
        List<ProductDto> products = productClient.findAll();
        return products.parallelStream()
                .filter(Objects::nonNull)
                .map(product -> new ItemModel(product, random.nextInt(10)))
                .toList();
    }

    @Override
    public Optional<ItemModel> findById(Long id) {
        log.info("Fetching product with id {} from products-ms...", id);
        ProductDto product = productClient.findById(id);

        if (product == null) {
            return Optional.empty();
        }

        return Optional.of(new ItemModel(product, random.nextInt(10)));
    }
}
