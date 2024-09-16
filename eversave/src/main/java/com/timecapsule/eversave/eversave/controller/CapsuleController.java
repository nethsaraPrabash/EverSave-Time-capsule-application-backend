package com.timecapsule.eversave.eversave.controller;

import com.timecapsule.eversave.eversave.dao.Capsule;
import com.timecapsule.eversave.eversave.service.CapsuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.timecapsule.eversave.eversave.dto.responsebody.ResponseBody;

@RestController
@RequestMapping("api/time/capsule")
@CrossOrigin(origins = "http://localhost:5173")
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

    @PutMapping("/update")
    public ResponseBody updateCapsule(@RequestParam int capsuleId, @Validated @RequestBody Capsule capsule){
        ResponseBody res = new ResponseBody();
        if(capsuleService.updateCapsule(capsule,capsuleId)){
            res.addResponse("status","success");
            res.addResponse("message","Capsule updated successfully");
        }else{
            res.addResponse("status","error");
            res.addResponse("message","Capsule does not exist");
        }
        return res;
    }

    @DeleteMapping("/delete/")
    public ResponseBody deleteCapsule(@RequestParam int capsuleId){
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
    public ResponseBody getAllCapsules(@RequestParam int userId){
        ResponseBody res = new ResponseBody();
        res.addResponse("status","success");
        res.addResponse("message","Capsules retrieved successfully");
        res.addCapsuleList("capsules",capsuleService.getAllCapsules(userId));
        return res;
    }





}
