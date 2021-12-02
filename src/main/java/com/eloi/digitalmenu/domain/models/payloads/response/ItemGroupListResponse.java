package com.eloi.digitalmenu.domain.models.payloads.response;

import java.util.List;
import java.util.stream.Collectors;

import com.eloi.digitalmenu.domain.models.ItemGroup;

public class ItemGroupListResponse {
    private List<ItemGroupResponse> itemGroups;
    private Integer count;

    public ItemGroupListResponse(List<ItemGroup> itemGroups) {
        setItemGroups(itemGroups.stream().map(x -> new ItemGroupResponse(x)).collect(Collectors.toList()));
        setCount(itemGroups.size());
    }

    public List<ItemGroupResponse> getItemGroups() {
        return itemGroups;
    }

    public void setItemGroups(List<ItemGroupResponse> itemGroups) {
        this.itemGroups = itemGroups;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
