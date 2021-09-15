package com.eloi.digitalmenu.controllers;

import com.eloi.digitalmenu.domain.models.Item;
import com.eloi.digitalmenu.domain.models.payloads.request.ItemRequest;
import com.eloi.digitalmenu.domain.models.payloads.response.ItemListResponse;
import com.eloi.digitalmenu.domain.models.payloads.response.ItemResponse;
import com.eloi.digitalmenu.domain.models.payloads.response.MessageResponse;
import com.eloi.digitalmenu.domain.services.ItemGroupService;
import com.eloi.digitalmenu.domain.services.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/item-groups/{groupId}/items")
public class ItemController {
    @Autowired
    private ItemGroupService itemGroupService;

    @Autowired
    private ItemService itemService;

    @PostMapping("")
    public ResponseEntity<?> create(@PathVariable Long groupId, @RequestBody ItemRequest model) {
        var itemGroup = itemGroupService.getItemGroup(groupId);

        if (itemGroup == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Categoria não existe"));
        }

        var item = model.mapTo(new Item(itemGroup));

        try {
            return new ResponseEntity<ItemResponse>(new ItemResponse(itemService.addItem(item)), HttpStatus.CREATED);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAll(@PathVariable Long groupId) {
        var itemGroup = itemGroupService.getItemGroup(groupId);

        if (itemGroup == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Categoria não existe"));
        }

        return ResponseEntity.ok(new ItemListResponse(itemService.findByItemGroup(itemGroup)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getItem(@PathVariable Long groupId, @PathVariable Long id) {
        var itemGroup = itemGroupService.getItemGroup(groupId);

        if (itemGroup == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Categoria não existe"));
        }
        
        var item = itemService.getItem(itemGroup, id);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(new ItemResponse(item));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long groupId, @PathVariable Long id, @RequestBody ItemRequest model) {
        var itemGroup = itemGroupService.getItemGroup(groupId);

        if (itemGroup == null) {
            return ResponseEntity.badRequest().body(new MessageResponse("Categoria não existe"));
        }

        var item = itemService.getItem(itemGroup, id);

        if (item == null) {
            return ResponseEntity.notFound().build();
        }

        try {
            item = model.mapTo(item);
            itemService.updateItem(item);
            return ResponseEntity.ok(new ItemResponse(item));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long groupId, @PathVariable Long id) {
        try {
            itemService.removeItem(id);
            return ResponseEntity.ok(new MessageResponse("Produto removido com sucesso."));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex);
        }
    }
}
