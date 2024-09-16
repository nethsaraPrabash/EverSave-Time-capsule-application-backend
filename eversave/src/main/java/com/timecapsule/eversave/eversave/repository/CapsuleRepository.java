package com.timecapsule.eversave.eversave.repository;


import com.timecapsule.eversave.eversave.dto.CapsuleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CapsuleRepository extends JpaRepository<CapsuleEntity, Integer> {
    boolean existsById(int capsuleId);
    void deleteById(int capsuleId);
    List<CapsuleEntity> findAllByUserId(int userId);
    CapsuleEntity findById(int capsule);

}
