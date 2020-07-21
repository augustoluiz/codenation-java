package com.quintomodulo.manipuladados.company.controller;

import com.quintomodulo.manipuladados.company.model.Company;
import com.quintomodulo.manipuladados.company.service.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyServiceInterface companyServiceInterface;

    @GetMapping
    public List<Company> findAll(){
        return this.companyServiceInterface.findAll();
    }

    @GetMapping("/{id}")
    public Company findById(@PathVariable("id") Long id){
        return this.companyServiceInterface.findById(id).get();
    }

    @GetMapping("/byAccelerationId/{accelerationId}")
    public List<Company> findbyAccelerationId(@PathVariable("accelerationId") Long accelerationId){
        return this.companyServiceInterface.findByAccelerationId(accelerationId);
    }

    @GetMapping("/byUserId/{userId}")
    public List<Company> findByUserId(@PathVariable("userId") Long userId){
        return this.companyServiceInterface.findByUserId(userId);
    }

    @PostMapping
    public Company save(Company company){
        return this.companyServiceInterface.save(company);
    }

}
