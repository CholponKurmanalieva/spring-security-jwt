package com.example.springsecurityjwt.rest;

import com.example.springsecurityjwt.mapper.AppUserMapper;
import com.example.springsecurityjwt.model.dto.AppUserDTO;
import com.example.springsecurityjwt.model.entity.AppUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@AllArgsConstructor
public class Test {

    @Value("${jwt.secret}")
    private String secret;

    private final AppUserMapper appUserMapper;

    public Test(AppUserMapper appUserMapper) {
        this.appUserMapper = appUserMapper;
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("allo");
    }
}