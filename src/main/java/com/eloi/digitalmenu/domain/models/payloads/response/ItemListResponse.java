package com.eloi.digitalmenu.domain.models.payloads.response;

import java.util.List;
import java.util.stream.Collectors;

import com.eloi.digitalmenu.domain.models.Item;

public class ItemListResponse {
    private List<ItemResponse> items;
    private Integer count;

    public ItemListResponse(List<Item> i) {
        setItems(i.stream().map(x -> new ItemResponse(x)).collect(Collectors.toList()));
        setCount(i.size());
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ItemResponse> getItems() {
        return items;
    }

    public void setItems(List<ItemResponse> items) {
        this.items = items;
    }
}
