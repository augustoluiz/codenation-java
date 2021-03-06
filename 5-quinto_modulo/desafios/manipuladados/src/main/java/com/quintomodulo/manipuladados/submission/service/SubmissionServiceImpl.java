package com.quintomodulo.manipuladados.submission.service;

import com.quintomodulo.manipuladados.submission.model.Submission;
import com.quintomodulo.manipuladados.submission.repository.SubmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class SubmissionServiceImpl implements SubmissionServiceInterface{

    @Autowired
    private SubmissionRepository submissionRepository;

    @Override
    public List<Submission> findAll() {
        return this.submissionRepository.findAll();
    }

    @Override
    public BigDecimal findHigherScoreByChallengeId(Long challengeId) {
        return this.submissionRepository.findHigherScoreByChallengeId(challengeId).orElse(BigDecimal.ZERO);
    }

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return this.submissionRepository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }

    @Override
    public Submission save(Submission object) {
        return this.submissionRepository.save(object);
    }
}
