package com.eloi.digitalmenu.domain.repositories;

import com.eloi.digitalmenu.domain.models.ItemGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemGroupRepository extends JpaRepository<ItemGroup, Long> {
    
}
