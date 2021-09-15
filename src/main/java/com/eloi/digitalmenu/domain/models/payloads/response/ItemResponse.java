package com.eloi.digitalmenu.domain.models.payloads.response;

import com.eloi.digitalmenu.domain.models.Item;

public class ItemResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean available;

    public ItemResponse(Item item) {
        setId(item.getId());
        setName(item.getName());
        setDescription(item.getDescription());
        setPrice(item.getPrice());
        setAvailable(item.getIsAvailable());
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
