package com.quintomodulo.manipuladados.challenge.controller;

import com.quintomodulo.manipuladados.challenge.model.Challenge;
import com.quintomodulo.manipuladados.challenge.service.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeServiceInterface challengeServiceInterface;

    @GetMapping
    public List<Challenge> findAll(){
        return this.challengeServiceInterface.findAll();
    }

    @GetMapping("/ByAccelerationId/{accelerationId}/UserId/{userId}")
    public List<Challenge> findByAccelerationIdAndUserId(@PathVariable("accelerationId") Long accelerationId,
                                                         @PathVariable("userId") Long userId){
        return this.challengeServiceInterface.findByAccelerationIdAndUserId(accelerationId, userId);
    }

    @PostMapping
    public Challenge save(@RequestBody Challenge challenge){
        return this.challengeServiceInterface.save(challenge);
    }

}
