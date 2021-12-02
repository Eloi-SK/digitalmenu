package com.eloi.digitalmenu.domain.models.payloads.response;

import com.eloi.digitalmenu.domain.models.ItemGroup;

public class ItemGroupResponse {
    private Long id;
    private String name;

    public ItemGroupResponse(ItemGroup itemGroup) {
        setId(itemGroup.getId());
        setName(this.name = itemGroup.getName());
    }

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
}
