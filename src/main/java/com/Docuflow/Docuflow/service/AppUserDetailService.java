package com.Docuflow.Docuflow.service;

import com.Docuflow.Docuflow.entity.UserEntity;
import com.Docuflow.Docuflow.repository.UserRepo;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class AppUserDetailService implements UserDetailsService {
        private final UserRepo userRepo;

        @Override
        public UserDetails loadUserByUsername(String email) throws UserPrincipalNotFoundException {
                UserEntity existingUser = userRepo.findByEmail(email)
                                .orElseThrow(() -> new UsernameNotFoundException("Email not found " + email));
                return new User(existingUser.getEmail(), existingUser.getPassword(), new ArrayList<>());
        }
}
