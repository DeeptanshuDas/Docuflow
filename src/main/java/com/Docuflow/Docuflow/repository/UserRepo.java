package com.Docuflow.Docuflow.repository;

import com.Docuflow.Docuflow.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByEmail(String email);

    Boolean exisexistsByEmail(String email);

}
