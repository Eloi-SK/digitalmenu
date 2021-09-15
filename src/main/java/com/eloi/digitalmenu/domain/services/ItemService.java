package com.eloi.digitalmenu.domain.services;

import java.util.List;

import com.eloi.digitalmenu.domain.models.Item;
import com.eloi.digitalmenu.domain.models.ItemGroup;

public interface ItemService {
    List<Item> findByItemGroup(ItemGroup itemGroup);
    Item addItem(Item item);
    Item getItem(ItemGroup group, Long id);
    Item updateItem(Item item);
    void removeItem(Long id);
}
