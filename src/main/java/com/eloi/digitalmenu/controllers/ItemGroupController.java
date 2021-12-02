package com.eloi.digitalmenu.controllers;

import com.eloi.digitalmenu.domain.models.ItemGroup;
import com.eloi.digitalmenu.domain.models.payloads.request.ItemGroupRequest;
import com.eloi.digitalmenu.domain.models.payloads.response.ItemGroupListResponse;
import com.eloi.digitalmenu.domain.models.payloads.response.MessageResponse;
import com.eloi.digitalmenu.domain.services.ItemGroupService;

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
@RequestMapping("api/item-groups")
public class ItemGroupController {
    @Autowired
    private ItemGroupService itemGroupService;

    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody ItemGroupRequest model) {
        try {
            var itemGroup = itemGroupService.addItemGroup(new ItemGroup(model.getName(), null));
            return new ResponseEntity<ItemGroup>(itemGroup, HttpStatus.CREATED);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(new ItemGroupListResponse(itemGroupService.getAll()));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody ItemGroupRequest model) {
        try {
            var itemGroup = itemGroupService.getItemGroup(id);
            itemGroup = model.mapTo(itemGroup);
            itemGroupService.updateItemGroup(itemGroup);
            return ResponseEntity.ok(itemGroup);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            itemGroupService.removeItemGroup(id);
            return ResponseEntity.ok(new MessageResponse("Categoria criada com sucesso."));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().body(ex);
        }
    }
}
