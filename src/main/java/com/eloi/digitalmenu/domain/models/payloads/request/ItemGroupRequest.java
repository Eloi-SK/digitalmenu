package com.eloi.digitalmenu.domain.models.payloads.request;

import com.eloi.digitalmenu.domain.models.ItemGroup;

public class ItemGroupRequest {
    private Long id;
    private String name;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemGroup map(ItemGroup itemGroup) {
        var iGroup = new ItemGroup();
        
        iGroup.setId(coalesce(id, itemGroup.getId()));
        iGroup.setName(coalesce(name, itemGroup.getName()));
        iGroup.setItems(coalesce(null, itemGroup.getItems()));

        return iGroup;
    }

    private <T> T coalesce(T a, T b) {
        return a == null ? b : a;
    }
    
}
