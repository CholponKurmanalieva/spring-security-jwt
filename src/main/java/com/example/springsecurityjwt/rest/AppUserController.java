package com.example.springsecurityjwt.rest;

import com.example.springsecurityjwt.model.dto.AppUserDTO;
import com.example.springsecurityjwt.model.request.AppUserCreateRequest;
import com.example.springsecurityjwt.service.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class AppUserController {

    private final AppUserService appUserService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('WRITE')")
    public ResponseEntity<AppUserDTO> create(@RequestBody @Valid AppUserCreateRequest request, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return ResponseEntity.internalServerError().build();

        return ResponseEntity.ok().body(appUserService.create(request));
    }

    @GetMapping("/get-all")
    public ResponseEntity<List<AppUserDTO>> getAll() {
        return ResponseEntity.ok().body(appUserService.getAll());
    }
}