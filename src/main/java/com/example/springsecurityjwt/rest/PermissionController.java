package com.example.springsecurityjwt.rest;

import com.example.springsecurityjwt.model.dto.PermissionDTO;
import com.example.springsecurityjwt.service.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/permission")
@AllArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping("/create")
    public ResponseEntity<PermissionDTO> create(@RequestBody PermissionDTO permissionDTO) {
        return ResponseEntity.ok().body(permissionService.save(permissionDTO));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<PermissionDTO>> getAll() {
        return ResponseEntity.ok().body(permissionService.getAll());
    }
}