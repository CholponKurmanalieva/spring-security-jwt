package com.example.springsecurityjwt.service.impl;

import com.example.springsecurityjwt.model.entity.AppUser;
import com.example.springsecurityjwt.model.entity.Permission;
import com.example.springsecurityjwt.model.entity.Role;
import com.example.springsecurityjwt.repository.AppUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class UserDetailService implements UserDetailsService {

    private final AppUserRepository appUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> optional = appUserRepository.findByUsername(username);

        if (!optional.isPresent())
            throw new EntityNotFoundException(String.format("User with %s username is not found!", username));

        AppUser appUser = optional.get();
        return new User(appUser.getUsername(), appUser.getPassword(), getAuthorities(appUser.getRole()));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Role role) {
        List<Permission> permissions = role.getPermissions();

        List<GrantedAuthority> authorities =  permissions.stream().map(permission -> new SimpleGrantedAuthority(permission.getAuthority())).collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority(role.getName()));

        return authorities;
    }
}