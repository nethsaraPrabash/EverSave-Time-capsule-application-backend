package com.timecapsule.eversave.eversave.service;

import com.timecapsule.eversave.eversave.dao.Capsule;
import com.timecapsule.eversave.eversave.service.IMPL.CapsuleServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CapsuleService {

    public boolean createCapsule(Capsule capsule);

    public boolean updateCapsule(Capsule capsule,int capsuleId);

    public boolean deleteCapsule(int capsuleId);

    public Capsule getCapsuleById(int capsuleId);

    public List<Capsule> getAllCapsules(int userId);
}
