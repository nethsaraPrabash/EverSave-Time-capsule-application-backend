package com.timecapsule.eversave.eversave.controller;

import com.timecapsule.eversave.eversave.dao.Auth;
import com.timecapsule.eversave.eversave.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.timecapsule.eversave.eversave.dto.responsebody.ResponseBody;

import java.util.Map;

@RestController
@RequestMapping("api/time/user")
@CrossOrigin(origins = "http://localhost:5173")

public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService){
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseBody registerUser(@Valid @RequestBody Auth auth){
        ResponseBody res = new ResponseBody();
        if(authService.registerUser(auth)){
            res.addResponse("status","success");
            res.addResponse("message","User registered successfully");
        }else{
            res.addResponse("status","error");
            res.addResponse("message","User already exists");
        }
        return res;
    }

    @PostMapping("/login")
    public ResponseBody loginUser(@RequestBody Map<String,String> loginRequest)
    {
        String email = loginRequest.get("email");
        String password = loginRequest.get("password");

        ResponseBody res = new ResponseBody();

        int userId = authService.loginUser(email,password);
        if(userId != -1){
            res.addResponse("status","success");
            res.addResponse("message","User logged in successfully");
            res.addResponse("userId",String.valueOf(userId));
    }
        else{
            res.addResponse("status","error");
            res.addResponse("message","Invalid credentials");
        }
        return res;
    }


}
