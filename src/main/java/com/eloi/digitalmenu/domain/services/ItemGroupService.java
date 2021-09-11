package com.eloi.digitalmenu.domain.services;

import java.util.List;

import com.eloi.digitalmenu.domain.models.ItemGroup;

public interface ItemGroupService {
    List<ItemGroup> getAll();
    ItemGroup addItemGroup(ItemGroup itemGroup);
    ItemGroup getItemGroup(Long id);
    ItemGroup updateItemGroup(ItemGroup itemGroup);
    void removeItemGroup(Long id);
}
