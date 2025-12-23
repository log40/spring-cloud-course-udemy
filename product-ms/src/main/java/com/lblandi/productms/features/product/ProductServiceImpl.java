package com.lblandi.productms.features.product;

import com.lblandi.productms.features.port.PortUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final PortUtils portUtils;

    public ProductServiceImpl(ProductRepository productRepository, PortUtils portUtils) {
        this.productRepository = productRepository;
        this.portUtils = portUtils;
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductEntity> findAll() {
        int port = portUtils.getLocalServerPort();
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
            throw new ProductNotFoundException(id);
        }

        ProductEntity product = productOptional.get();
        product.setPort(portUtils.getLocalServerPort());
        return Optional.of(product);
    }
}
