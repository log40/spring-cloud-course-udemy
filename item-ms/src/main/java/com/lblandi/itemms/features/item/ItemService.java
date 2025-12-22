package com.lblandi.itemms.features.item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<ItemModel> findAll();
    Optional<ItemModel> findById(Long id);
}
