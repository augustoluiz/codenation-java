package com.modulosete.oauth.service.impl;

import com.modulosete.oauth.entity.Submission;
import com.modulosete.oauth.repository.SubmissionRepository;
import com.modulosete.oauth.service.interfaces.SubmissionServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubmissionService implements SubmissionServiceInterface {

    private SubmissionRepository repository;

    @Override
    public List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId) {
        return repository.findByChallengeIdAndAccelerationId(challengeId, accelerationId);
    }
}
