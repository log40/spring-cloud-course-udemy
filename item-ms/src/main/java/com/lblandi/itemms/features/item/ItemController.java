package com.lblandi.itemms.features.item;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {
    private final ItemService itemService;


    public ItemController(
            @Qualifier("webClientItemServiceImpl") ItemService itemService
    ) {
        this.itemService = itemService;
    }

    @GetMapping
    public ResponseEntity<List<ItemModel>> findAll() {
        return ResponseEntity.status(200).body(itemService.findAll());
    }

    @GetMapping("/{item_id}")
    public ResponseEntity<ItemModel> findById(@PathVariable("item_id") Long itemId) {
        return ResponseEntity.status(200)
                .body(itemService.findById(itemId).orElse(null));
    }
}
