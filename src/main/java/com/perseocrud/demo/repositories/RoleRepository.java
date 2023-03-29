package com.perseocrud.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.perseocrud.demo.models.Role;

public interface RoleRepository  extends JpaRepository <Role, Long> {
    
}
