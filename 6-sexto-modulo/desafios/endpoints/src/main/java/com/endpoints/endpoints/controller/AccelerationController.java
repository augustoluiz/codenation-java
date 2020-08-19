package com.endpoints.endpoints.controller;

import com.endpoints.endpoints.entity.Acceleration;
import com.endpoints.endpoints.service.interfaces.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationServiceInterface accelerationServiceInterface;

    @GetMapping("/{accelerationId}")
    public Acceleration findById(@PathVariable("accelerationId") Long accelerationId){
        return accelerationServiceInterface.findById(accelerationId).get();
    }

    @GetMapping
    public List<Acceleration> findByCompanyId(@RequestParam("companyId") Long companyId){
        return accelerationServiceInterface.findByCompanyId(companyId);
    }

}
