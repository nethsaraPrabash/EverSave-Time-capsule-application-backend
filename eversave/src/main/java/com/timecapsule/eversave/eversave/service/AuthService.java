package com.timecapsule.eversave.eversave.service;

import com.timecapsule.eversave.eversave.dao.Auth;
import org.springframework.validation.annotation.Validated;

@Validated
public interface AuthService{

    boolean registerUser(Auth auth);
    int loginUser(String email, String password);




}
