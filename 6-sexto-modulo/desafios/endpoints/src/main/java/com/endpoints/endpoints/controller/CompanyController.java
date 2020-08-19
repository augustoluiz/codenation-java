package com.endpoints.endpoints.controller;

import com.endpoints.endpoints.entity.Company;
import com.endpoints.endpoints.service.interfaces.CompanyServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyServiceInterface companyServiceInterface;

    @GetMapping("/{companyId}")
    public Company findById(@PathVariable("companyId") Long companyId){
        return this.companyServiceInterface.findById(companyId).get();
    }

    @GetMapping
    public List<Company> findByAccelerationIdOrUserId(@RequestParam(name = "accelerationId", required = false) Optional<Long> accelerationId,
                                                      @RequestParam(name = "userId", required = false) Optional<Long> userId){

        return accelerationId.isPresent() ?
                this.companyServiceInterface.findByAccelerationId(accelerationId.get()) : userId.isPresent() ?
                this.companyServiceInterface.findByUserId(userId.get()) : Collections.EMPTY_LIST;
    }

}
