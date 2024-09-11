package com.timecapsule.eversave.eversave.service.IMPL;

import com.timecapsule.eversave.eversave.dao.Auth;
import com.timecapsule.eversave.eversave.dto.AuthEntity;
import com.timecapsule.eversave.eversave.repository.AuthRepository;
import com.timecapsule.eversave.eversave.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;



@Service
public class AuthServiceIMPL implements AuthService {

   private final AuthRepository authRepository;
   private final ModelMapper modelMapper;

   @Autowired
    public AuthServiceIMPL(AuthRepository authRepository, ModelMapper modelMapper){
         this.authRepository = authRepository;
         this.modelMapper = modelMapper;
    }

     @Override
     public boolean registerUser(Auth auth) {
         AuthEntity authEntity = modelMapper.map(auth, AuthEntity.class);
         return authRepository.save(authEntity) == authEntity;
     }

     @Override
    public int loginUser(String email, String password) {
        if(authRepository.existsByEmail(email) && authRepository.findByEmail(email).getPassword().equals(password)){
            return authRepository.findByEmail(email).getId();

        }
        return -1;
    }





}
