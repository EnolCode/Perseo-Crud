package com.perseocrud.demo.services;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.perseocrud.demo.exception.ProfileNotFoundException;
import com.perseocrud.demo.models.Profile;
import com.perseocrud.demo.repositories.ProfileRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProfileService implements BaseService<Profile> {

    private ProfileRepository profileRepository;

    @Override
    @Transactional
    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    @Override
    @Transactional
    public Page<Profile> findAll(Pageable pageable) {
        return profileRepository.findAll(pageable);

    }

    @Override
    @Transactional
    public Profile findById(Long id) {
        return profileRepository.findById(id)
                .orElseThrow(() -> new ProfileNotFoundException("profile not found with id: " + id));
    }

    @Override
    @Transactional
    public Profile save(Profile profile) {
        return profileRepository.save(profile);

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Profile profileDeleted = findById(id);
        profileRepository.deleteById(profileDeleted.getId());
    }

    @Transactional
    public Profile updateprofile(Long id, Profile profileDetails) {
        Profile profile = findById(id);
        profile.setName(profileDetails.getName());
        profile.setUser(profileDetails.getUser());
        profile.setName(profileDetails.getName());
        profile.setWorkExperience(profileDetails.getWorkExperience());
        return save(profile);
    }

}
