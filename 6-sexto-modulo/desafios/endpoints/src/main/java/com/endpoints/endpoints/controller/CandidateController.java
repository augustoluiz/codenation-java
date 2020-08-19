package com.endpoints.endpoints.controller;

import com.endpoints.endpoints.dto.CandidateDTO;
import com.endpoints.endpoints.mappers.CandidateMapper;
import com.endpoints.endpoints.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    @Autowired
    private CandidateServiceInterface candidateServiceInterface;

    @Autowired
    private CandidateMapper candidateMapper;

    @GetMapping("/{userId}/{accelerationId}/{companyId}")
    public CandidateDTO findById(@PathVariable("userId") Long userId,
                                 @PathVariable("companyId") Long companyId,
                                 @PathVariable("accelerationId") Long accelerationId){
        return candidateMapper.map(this.candidateServiceInterface.findById(userId, companyId, accelerationId).get());
    }

    @GetMapping
    public List<CandidateDTO> findByCompanyId(@RequestParam("companyId") Long companyId){
        return candidateMapper.map(this.candidateServiceInterface.findByCompanyId(companyId));
    }

    @GetMapping("/acceleration/{accelerationId}")
    public List<CandidateDTO> findByAccelerationId(@PathVariable("accelerationId") Long accelerationId){
        return candidateMapper.map(this.candidateServiceInterface.findByAccelerationId(accelerationId));
    }
}
