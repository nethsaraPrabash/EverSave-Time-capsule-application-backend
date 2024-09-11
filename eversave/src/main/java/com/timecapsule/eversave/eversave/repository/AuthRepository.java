package com.timecapsule.eversave.eversave.repository;


import com.timecapsule.eversave.eversave.dto.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthRepository extends JpaRepository<AuthEntity, String> {
    boolean existsByEmail(String email);
    AuthEntity findByEmail(String email);

}
