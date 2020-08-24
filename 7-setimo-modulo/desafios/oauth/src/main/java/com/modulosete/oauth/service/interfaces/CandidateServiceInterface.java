package com.modulosete.oauth.service.interfaces;

import com.modulosete.oauth.entity.Candidate;
import com.modulosete.oauth.service.interfaces.ServiceInterface;

import java.util.List;
import java.util.Optional;

public interface CandidateServiceInterface extends ServiceInterface<Candidate> {

    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByCompanyId(Long companyId);

    List<Candidate> findByAccelerationId(Long accelerationId);
}
