package com.project.expensetracker.service;

import com.project.expensetracker.model.Profile;
import com.project.expensetracker.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ProfileService {

    @Autowired
    ProfileRepository profileRepository;

    public Profile getProfileById(int profileId) {
        return profileRepository.findById(profileId).orElse(null);
    }

    public void saveProfile(Profile profile) {
        profileRepository.save(profile);
    }

    public void updateProfile(Profile profile) {
        Profile profileToUpdate = getProfileById(profile.getProfileId());
        if (profileToUpdate != null) {
            profileToUpdate.setName(profile.getName());
            profileToUpdate.setEmailId(profile.getEmailId());
            profileRepository.save(profileToUpdate);
        }
    }

    public void deleteProfile(int profileId) {
        profileRepository.deleteById(profileId);
    }
}
