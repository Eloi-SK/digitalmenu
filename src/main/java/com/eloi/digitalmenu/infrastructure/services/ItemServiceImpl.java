package com.eloi.digitalmenu.infrastructure.services;

import java.util.List;

import com.eloi.digitalmenu.domain.models.Item;
import com.eloi.digitalmenu.domain.models.ItemGroup;
import com.eloi.digitalmenu.domain.repositories.ItemRepository;
import com.eloi.digitalmenu.domain.services.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> findByItemGroup(ItemGroup itemGroup) {
        return itemRepository.findByItemGroup(itemGroup);
    }

    @Override
    public Item addItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item getItem(ItemGroup group, Long id) {
        return itemRepository.findByGroupAndId(group, id);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public void removeItem(Long id) {
        var item = itemRepository.getById(id);
        itemRepository.delete(item);
    }
}
