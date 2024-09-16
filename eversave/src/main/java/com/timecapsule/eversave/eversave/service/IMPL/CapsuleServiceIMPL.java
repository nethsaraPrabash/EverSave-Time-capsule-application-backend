package com.timecapsule.eversave.eversave.service.IMPL;

import com.timecapsule.eversave.eversave.dao.Capsule;
import com.timecapsule.eversave.eversave.dto.CapsuleEntity;
import com.timecapsule.eversave.eversave.repository.CapsuleRepository;
import com.timecapsule.eversave.eversave.service.CapsuleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CapsuleServiceIMPL implements CapsuleService {

    private final CapsuleRepository capsuleRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public CapsuleServiceIMPL(CapsuleRepository capsuleRepository, ModelMapper modelMapper){
        this.capsuleRepository = capsuleRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean createCapsule(Capsule capsule){
        CapsuleEntity capsuleEntity = modelMapper.map(capsule, CapsuleEntity.class);
        return capsuleRepository.save(capsuleEntity) == capsuleEntity;
    }

    @Override
    public boolean updateCapsule(Capsule capsule, int capsuleId){
        if (capsuleRepository.existsById(capsuleId)) {
            // Map the Capsule object to CapsuleEntity
            CapsuleEntity capsuleEntity = modelMapper.map(capsule, CapsuleEntity.class);

            // Set the capsuleId to ensure the existing record is updated
            capsuleEntity.setId(capsuleId);

            // Save the updated capsule entity
            capsuleRepository.save(capsuleEntity);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteCapsule(int capsuleId){
        if(capsuleRepository.existsById(capsuleId)){
            capsuleRepository.deleteById(capsuleId);
            return true;
        }
        return false;
    }

    @Override
    public List<Capsule> getAllCapsules(int userId){
        List<Capsule> capsules = new ArrayList<>();
        for(CapsuleEntity capsuleEntity : capsuleRepository.findAllByUserId(userId)){
            capsules.add(modelMapper.map(capsuleEntity, Capsule.class));
        }
        return capsules;
    }

    @Override
    public Capsule getCapsuleById(int capsuleId)
    {
        CapsuleEntity capsuleEntity = capsuleRepository.findById(capsuleId);
        return modelMapper.map(capsuleEntity, Capsule.class);
    }



}
