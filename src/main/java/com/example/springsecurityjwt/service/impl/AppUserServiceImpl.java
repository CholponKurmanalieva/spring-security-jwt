package com.example.springsecurityjwt.service.impl;

import com.example.springsecurityjwt.exception.UserExistsException;
import com.example.springsecurityjwt.mapper.AppUserCreateRequestMapper;
import com.example.springsecurityjwt.mapper.AppUserMapper;
import com.example.springsecurityjwt.model.dto.AppUserDTO;
import com.example.springsecurityjwt.model.entity.AppUser;
import com.example.springsecurityjwt.model.entity.Role;
import com.example.springsecurityjwt.model.request.AppUserCreateRequest;
import com.example.springsecurityjwt.repository.AppUserRepository;
import com.example.springsecurityjwt.repository.RoleRepository;
import com.example.springsecurityjwt.service.AppUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@AllArgsConstructor
public class AppUserServiceImpl implements AppUserService {

    private final AppUserRepository appUserRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AppUserMapper appUserMapper;
    private final AppUserCreateRequestMapper requestMapper;


    @Override
    public AppUserDTO create(AppUserCreateRequest request) {
        log.info("User {} is creating ", request);

        if (appUserRepository.existsByUsername(request.getUsername()))
            throw new UserExistsException(String.format("User %s is exists ", request.getUsername()));

        AppUser appUser = requestMapper.toEntity(request);
        Optional<Role> role = roleRepository.findById(request.getRoleId());

        role.ifPresent(appUser::setRole);
        appUser.setPassword(passwordEncoder.encode(request.getPassword()));

        return appUserMapper.toDTO(appUserRepository.save(appUser));
    }

    @Override
    public List<AppUserDTO> getAll() {
        return appUserMapper.toDTOs(appUserRepository.findAll());
    }
}