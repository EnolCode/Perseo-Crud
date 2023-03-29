package com.perseocrud.demo.security;

import org.springframework.security.core.GrantedAuthority;

import com.perseocrud.demo.models.Role;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SecurityRole implements GrantedAuthority {

    private final Role role;

    @Override
    public String getAuthority() {
        return role.getRoleName();
    }
}
