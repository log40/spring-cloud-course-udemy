package com.lblandi.itemms.features.item;

import com.lblandi.itemms.features.product.ProductDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

@Service
public class WebClientItemServiceImpl implements ItemService {
    private final WebClient.Builder webClient;
    private final Random random;

    public WebClientItemServiceImpl(WebClient.Builder webClient) {
        this.webClient = webClient;
        this.random = new Random();
    }

    @Override
    public List<ItemModel> findAll() {
        return webClient.build()
                .get()
                .uri("http://products-ms/api/v1/products")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                    .bodyToFlux(ProductDto.class)
                    .map(product -> new ItemModel(product, random.nextInt(10)))
                    .collectList()
                        .block();
    }

    @Override
    public Optional<ItemModel> findById(Long id) {
        Map<String, Long> params = Map.of("id", id);
        return webClient.build()
                .get()
                .uri("http://products-ms/api/v1/products/{id}", params)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                    .bodyToMono(ProductDto.class)
                    .map(product -> new ItemModel(product, random.nextInt(10)))
                        .blockOptional();
    }
}
