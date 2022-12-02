package com.project.expensetracker.controller;

import com.project.expensetracker.handler.ResponseHandler;
import com.project.expensetracker.model.Profile;
import com.project.expensetracker.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @GetMapping("/{id}")
    public ResponseEntity<Object> getProfileDetails(@PathVariable(name = "id") int profileId) {
        Profile profile = profileService.getProfileById(profileId);
        if (profile != null) {
            return ResponseHandler.generateResponse(profile, "Profile retrieved successfully !", HttpStatus.OK);
        }
        else {
            return ResponseHandler.generateResponse(profile, "No profile exists for id " + profileId, HttpStatus.OK);
        }
    }

    @PostMapping("/save")
    public ResponseEntity<Object> createprofile(@RequestBody Profile profile) {
        try {
            profileService.saveProfile(profile);
            return ResponseEntity.ok().body("Profile for " + profile.getName() + " is created Successfully");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error creating profile for " + profile.getName());
        }
    }

    @PutMapping("/update")
    public ResponseEntity<Object> updateProfile(@RequestBody Profile profile) {
        try {
            profileService.updateProfile(profile);
            return ResponseEntity.ok().body("Profile for " + profile.getName() + " is updated Successfully");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error updating profile " + profile.getName());
        }
    }

    @DeleteMapping("/delete/{profileId}")
    public ResponseEntity<Object> deleteProfile(@PathVariable int profileId) {
        try {
            profileService.deleteProfile(profileId);
            return ResponseEntity.ok().body("Profile deleted Successfully");
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error deleteing profile");
        }
    }
}
