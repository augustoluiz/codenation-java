package com.endpoints.endpoints.controller;

import com.endpoints.endpoints.entity.Challenge;
import com.endpoints.endpoints.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/challenge")
public class ChallengeController {

    @Autowired
    private ChallengeServiceInterface challengeServiceInterface;

    @GetMapping
    public List<Challenge> findByAccelerationIdAndUserId(@RequestParam("accelerationId") Long accelerationId,
                                                         @RequestParam("userId") Long userId){
        return this.challengeServiceInterface.findByAccelerationIdAndUserId(accelerationId, userId);
    }

}
