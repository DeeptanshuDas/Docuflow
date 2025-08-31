package com.Docuflow.Docuflow.service;

import com.Docuflow.Docuflow.io.ProfileRequest;
import com.Docuflow.Docuflow.io.ProfileResponse;

public interface ProfileService {
    ProfileResponse createProfile(ProfileRequest request);

}
