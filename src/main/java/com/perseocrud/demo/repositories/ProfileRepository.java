package com.perseocrud.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.perseocrud.demo.models.Profile;

public interface ProfileRepository  extends JpaRepository <Profile, Long> {
    
}
