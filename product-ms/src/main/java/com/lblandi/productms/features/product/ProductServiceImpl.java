package com.lblandi.productms.features.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final Environment env;

    public ProductServiceImpl(ProductRepository productRepository, Environment env) {
        this.productRepository = productRepository;
        this.env = env;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductEntity> findAll() {
        int port = env.getProperty("server.port", Integer.class);
        return ((List<ProductEntity>) productRepository.findAll())
                .stream()
                .peek(product -> product.setPort(port))
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductEntity> findById(Long id) {
        Optional<ProductEntity> productOptional = productRepository.findById(id);

        if (productOptional.isEmpty()) {
            return Optional.empty();
        }

        ProductEntity product = productOptional.get();
        product.setPort(env.getProperty("server.port", Integer.class));
        return Optional.of(product);
    }
}
