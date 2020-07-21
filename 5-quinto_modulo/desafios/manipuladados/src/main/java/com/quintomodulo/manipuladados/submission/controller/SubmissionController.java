package com.quintomodulo.manipuladados.submission.controller;

import com.quintomodulo.manipuladados.submission.model.Submission;
import com.quintomodulo.manipuladados.submission.service.SubmissionServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionServiceInterface submissionServiceInterface;

    @GetMapping
    public Iterable<Submission> findAll(){
        return this.submissionServiceInterface.findAll();
    }

    @GetMapping("/higherScore/{id}")
    public BigDecimal findHigherScoreByChallengeId(@PathVariable("id") Long challengeId){
        return this.submissionServiceInterface.findHigherScoreByChallengeId(challengeId);
    }

    @GetMapping("/byChallengeId/{challengeId}/byAccelerationId/{accelerationId}")
    public List<Submission> findByChallegeIdAndAccelerationId(@PathVariable("challengeId") Long challengeId,
                                                              @PathVariable("accelerationId") Long accelerationId){
        return this.submissionServiceInterface.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @PostMapping
    public Submission save(@RequestBody Submission submission){
        return this.submissionServiceInterface.save(submission);
    }

}
