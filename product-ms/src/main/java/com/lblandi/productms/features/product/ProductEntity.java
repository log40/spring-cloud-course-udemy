package com.lblandi.productms.features.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Double price;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}

