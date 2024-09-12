package com.timecapsule.eversave.eversave.dto.responsebody;


import com.timecapsule.eversave.eversave.dao.Auth;
import com.timecapsule.eversave.eversave.dao.Capsule;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

@Data
public class ResponseBody {

    private HashMap<String, List<String>> messageResponse = new HashMap<>();
    private HashMap<String, List<Auth>> authResponse = new HashMap<>();
    private HashMap<String, List<Capsule>> capsuleResponse = new HashMap<>();

    public void addResponse(String status, String message) {
        this.messageResponse.computeIfAbsent(status, k -> new ArrayList<>()).add(message);
    }

    public void addUser(String auth, Auth auth1) {
        this.authResponse.computeIfAbsent(auth, k -> new ArrayList<>()).add(auth1);
    }

    public void addCapsule(String capsule, Capsule capsule1){
        this.capsuleResponse.computeIfAbsent(capsule, k -> new ArrayList<>()).add(capsule1);
    }

    public void addCapsuleList(String capsule, List<Capsule> capsule1){
        this.capsuleResponse.computeIfAbsent(capsule, k -> new ArrayList<>()).addAll(capsule1);
    }



}
