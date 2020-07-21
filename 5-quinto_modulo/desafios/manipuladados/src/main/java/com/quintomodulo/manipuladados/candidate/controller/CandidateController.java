package com.quintomodulo.manipuladados.candidate.controller;

import com.quintomodulo.manipuladados.candidate.model.Candidate;
import com.quintomodulo.manipuladados.candidate.service.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceInterface candidateServiceInterface;

    @GetMapping
    public Iterable<Candidate> findAll(){
        return this.candidateServiceInterface.findAll();
    }

    @GetMapping("/byCompanyId/{id}")
    public List<Candidate> findByCompanyId(@PathVariable("id") Long companyId){
        return this.candidateServiceInterface.findByCompanyId(companyId);
    }

    @GetMapping("/byAccelerationId/{id}")
    public List<Candidate> findByAccelerationId(@PathVariable("id") Long accelerationId){
        return this.candidateServiceInterface.findByAccelerationId(accelerationId);
    }

    @PostMapping
    public Candidate save(@RequestBody Candidate candidate){
        return this.candidateServiceInterface.save(candidate);
    }
}
