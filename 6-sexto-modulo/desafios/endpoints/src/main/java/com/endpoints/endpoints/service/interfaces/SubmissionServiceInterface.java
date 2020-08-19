package com.endpoints.endpoints.service.interfaces;

import com.endpoints.endpoints.entity.Submission;

import java.util.List;

public interface SubmissionServiceInterface extends ServiceInterface<Submission> {

    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
