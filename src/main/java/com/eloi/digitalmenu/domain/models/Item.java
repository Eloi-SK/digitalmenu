package com.eloi.digitalmenu.domain.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private Double price;
    
    private Boolean isAvailable;

    @ManyToOne(optional = false)
    @JoinColumn(name = "item_group_id", nullable = false, referencedColumnName = "id")
    private ItemGroup itemGroup;

    public Item() { }

    public Item(ItemGroup itemGroup) {
        this.setItemGroup(itemGroup);
    }

    public Item(String name, String description, Double price, Boolean isAvailable, ItemGroup itemGroup) {
        this.setName(name);
        this.setDescription(description);
        this.setPrice(price);
        this.setIsAvailable(isAvailable);
        this.itemGroup = itemGroup;
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

    public ItemGroup getItemGroup() {
        return itemGroup;
    }

    public void setItemGroup(ItemGroup itemGroup) {
        this.itemGroup = itemGroup;
    }
}
