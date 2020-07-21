package com.quintomodulo.manipuladados.acceleration.controller;

import com.quintomodulo.manipuladados.acceleration.model.Acceleration;
import com.quintomodulo.manipuladados.acceleration.service.AccelerationServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

    @Autowired
    private AccelerationServiceInterface accelerationServiceInterface;

    @GetMapping
    public List<Acceleration> findAll(){
        return this.accelerationServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public Acceleration findAccelerationById(@PathVariable("id") Long id){
        return this.accelerationServiceInterface.findAccelerationById(id).get();
    }

    @GetMapping("/byName/{name}")
    public Acceleration findAccelerationByName(@PathVariable("name") String name){
        return this.accelerationServiceInterface.findAccelerationByName(name).get();
    }

    @GetMapping("/byCompanyId/{companyId}")
    public List<Acceleration> findByCompanyId(@PathVariable("companyId") Long companyId){
        return this.accelerationServiceInterface.findByCompanyId(companyId);
    }

    @PostMapping
    public Acceleration save(@RequestBody Acceleration acceleration){
        return this.accelerationServiceInterface.save(acceleration);
    }

}
