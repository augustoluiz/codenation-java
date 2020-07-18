package com.quintomodulo.manipuladados.submission.service;

import com.quintomodulo.manipuladados.generic_interface.ServiceInterface;
import com.quintomodulo.manipuladados.submission.model.Submission;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionServiceInterface extends ServiceInterface<Submission> {

    BigDecimal findHigherScoreByChallengeId(Long challengeId);

    List<Submission> findByChallengeIdAndAccelerationId(Long challengeId, Long accelerationId);

}
