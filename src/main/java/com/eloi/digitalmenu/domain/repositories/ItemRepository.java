package com.eloi.digitalmenu.domain.repositories;

import java.util.List;

import com.eloi.digitalmenu.domain.models.Item;
import com.eloi.digitalmenu.domain.models.ItemGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findByItemGroup(ItemGroup itemGroup);
    
    @Query("SELECT i FROM Item i WHERE i.itemGroup = ?1 AND i.id = ?2")
    Item findByGroupAndId(ItemGroup itemGroup, Long id);
}
