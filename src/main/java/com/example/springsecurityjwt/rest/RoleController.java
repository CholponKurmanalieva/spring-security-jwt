package com.example.springsecurityjwt.rest;

import com.example.springsecurityjwt.model.dto.RoleDTO;
import com.example.springsecurityjwt.model.request.RoleCreateRequest;
import com.example.springsecurityjwt.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/role")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping("/create")
    public ResponseEntity<RoleDTO> create(@RequestBody @Valid RoleCreateRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.badRequest().build();

        return ResponseEntity.ok().body(roleService.create(request));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<RoleDTO>> getAll() {
        return ResponseEntity.ok().body(roleService.getAll());
    }
}