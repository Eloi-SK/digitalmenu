package com.eloi.digitalmenu.controllers;

import com.eloi.digitalmenu.domain.models.payloads.response.ItemGroupListResponse;
import com.eloi.digitalmenu.domain.services.ItemGroupService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/public/item-groups")
public class PublicItemGroupController {
    @Autowired
    private ItemGroupService itemGroupService;

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(new ItemGroupListResponse(itemGroupService.getAll()));
    }
}
