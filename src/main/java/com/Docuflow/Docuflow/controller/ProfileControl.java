package com.Docuflow.Docuflow.controller;

import com.Docuflow.Docuflow.io.ProfileRequest;
import com.Docuflow.Docuflow.io.ProfileResponse;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.Docuflow.Docuflow.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1.0")
@RequiredArgsConstructor
public class ProfileControl {
    private final ProfileService profileService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public ProfileResponse register(@RequestBody ProfileRequest request) {
        ProfileResponse response = profileService.createProfile(request);
        return response;
    }
}
