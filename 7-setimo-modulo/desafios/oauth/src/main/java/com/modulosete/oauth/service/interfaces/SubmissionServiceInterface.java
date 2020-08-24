package com.modulosete.oauth.service.interfaces;

import com.modulosete.oauth.entity.Submission;

import java.util.List;

public interface SubmissionServiceInterface extends ServiceInterface<Submission> {

    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
