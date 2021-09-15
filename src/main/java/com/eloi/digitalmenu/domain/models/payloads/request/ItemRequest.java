package com.eloi.digitalmenu.domain.models.payloads.request;

import com.eloi.digitalmenu.domain.models.Item;

public class ItemRequest {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean isAvailable;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Item mapTo(Item item) {
        item.setName(coalesce(name, item.getName()));
        item.setDescription(coalesce(description, item.getDescription()));
        item.setPrice(coalesce(price, item.getPrice()));
        item.setIsAvailable(coalesce(isAvailable, item.getIsAvailable()));
        return item;
    }

    private <T> T coalesce(T a, T b) {
        return a == null ? b : a;
    }
}
