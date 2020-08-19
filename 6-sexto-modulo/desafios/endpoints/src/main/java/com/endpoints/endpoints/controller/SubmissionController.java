package com.endpoints.endpoints.controller;

import com.endpoints.endpoints.dto.SubmissionDTO;
import com.endpoints.endpoints.mappers.SubmissionMapper;
import com.endpoints.endpoints.service.interfaces.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionServiceInterface submissionServiceInterface;

    @Autowired
    private SubmissionMapper submissionMapper;

    @GetMapping
    public List<SubmissionDTO> findByChallengeIdAndAccelerationId(@RequestParam("challengeId") Long challengeId,
                                                                  @RequestParam("accelerationId") Long accelerationId){
        return submissionMapper.map(submissionServiceInterface.findByChallengeIdAndAccelerationId(challengeId, accelerationId));
    }

}
