package com.timecapsule.eversave.eversave.controller;

import com.timecapsule.eversave.eversave.dao.Capsule;
import com.timecapsule.eversave.eversave.service.CapsuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.timecapsule.eversave.eversave.dto.responsebody.ResponseBody;

@RestController
@RequestMapping("api/time/capsule")
@CrossOrigin
public class CapsuleController {

    private final CapsuleService capsuleService;

    @Autowired
    public CapsuleController(CapsuleService capsuleService){
        this.capsuleService = capsuleService;
    }


    @PostMapping("/create")
    public ResponseBody createCapsule(@Validated @RequestBody Capsule capsule){
        ResponseBody res = new ResponseBody();
        if(capsuleService.createCapsule(capsule)){
            res.addResponse("status","success");
            res.addResponse("message","Capsule created successfully");
        }else{
            res.addResponse("status","error");
            res.addResponse("message","Capsule already exists");
        }
        return res;
    }

    @PutMapping("/update/{capsuleId}")
    public ResponseBody updateCapsule(@PathVariable int capsuleId, @Validated @RequestBody Capsule capsule){
        ResponseBody res = new ResponseBody();
        if(capsuleService.updateCapsule(capsule)){
            res.addResponse("status","success");
            res.addResponse("message","Capsule updated successfully");
        }else{
            res.addResponse("status","error");
            res.addResponse("message","Capsule does not exist");
        }
        return res;
    }

    @DeleteMapping("/delete/{capsuleId}")
    public ResponseBody deleteCapsule(@PathVariable int capsuleId){
        ResponseBody res = new ResponseBody();
        if(capsuleService.deleteCapsule(capsuleId)){
            res.addResponse("status","success");
            res.addResponse("message","Capsule deleted successfully");
        }else{
            res.addResponse("status","error");
            res.addResponse("message","Capsule does not exist");
        }
        return res;
    }

    @GetMapping("/get/{capsuleId}")
    public ResponseBody getCapsuleById(@PathVariable int capsuleId){
        ResponseBody res = new ResponseBody();
        Capsule capsule = capsuleService.getCapsuleById(capsuleId);
        if(capsule != null){
            res.addResponse("status","success");
            res.addResponse("message","Capsule retrieved successfully");
            res.addCapsule("capsule",capsule);
        }else{
            res.addResponse("status","error");
            res.addResponse("message","Capsule does not exist");
        }
        return res;
    }

    @GetMapping("/get/all")
    public ResponseBody getAllCapsules(){
        ResponseBody res = new ResponseBody();
        res.addResponse("status","success");
        res.addResponse("message","Capsules retrieved successfully");
        res.addCapsuleList("capsules",capsuleService.getAllCapsules());
        return res;
    }





}
