package com.eloi.digitalmenu.infrastructure.services;

import java.util.List;

import com.eloi.digitalmenu.domain.models.ItemGroup;
import com.eloi.digitalmenu.domain.repositories.ItemGroupRepository;
import com.eloi.digitalmenu.domain.services.ItemGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemGroupServiceImpl implements ItemGroupService {
    @Autowired
    private ItemGroupRepository itemGroupRepository;

    @Override
    public List<ItemGroup> getAll() {
        return itemGroupRepository.findAll();
    }
    
    @Override
    public ItemGroup addItemGroup(ItemGroup itemGroup) {
        return itemGroupRepository.save(itemGroup);
    }

    @Override
    public ItemGroup getItemGroup(Long id) {
        return itemGroupRepository.getById(id);
    }

    @Override
    public ItemGroup updateItemGroup(ItemGroup itemGroup) {
        return itemGroupRepository.save(itemGroup);   
    }

    @Override
    public void removeItemGroup(Long id) {
        var itemGroup = itemGroupRepository.getById(id);
        itemGroupRepository.delete(itemGroup);
    }
}
