package com.eloi.digitalmenu.controllers;

import com.eloi.digitalmenu.domain.models.payloads.response.ItemListResponse;
import com.eloi.digitalmenu.domain.models.payloads.response.MessageResponse;
import com.eloi.digitalmenu.domain.services.ItemGroupService;
import com.eloi.digitalmenu.domain.services.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/public/item-groups/{groupId}/items")
public class PublicItemController {
    @Autowired
    private ItemGroupService itemGroupService;
    
    @Autowired
    private ItemService itemService;

    @GetMapping("")
    public ResponseEntity<?> getAll(@PathVariable Long groupId) {
        var itemGroup = itemGroupService.getItemGroup(groupId);

        if (itemGroup == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Categoria não existe"));
        }

        return ResponseEntity.ok(new ItemListResponse(itemService.findByItemGroup(itemGroup)));
    }
}
