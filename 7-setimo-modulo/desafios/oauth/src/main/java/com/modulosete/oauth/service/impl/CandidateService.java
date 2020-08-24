package com.modulosete.oauth.service.impl;

import com.modulosete.oauth.entity.Candidate;
import com.modulosete.oauth.repository.CandidateRepository;
import com.modulosete.oauth.service.interfaces.CandidateServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CandidateService implements CandidateServiceInterface {

    private CandidateRepository candidateRepository;

    @Override
    public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
        return candidateRepository.findByIdUserIdAndIdCompanyIdAndIdAccelerationId(userId, companyId, accelerationId);
    }

    @Override
    public List<Candidate> findByCompanyId(Long companyId) {
        return candidateRepository.findByIdCompanyId(companyId);
    }

    @Override
    public List<Candidate> findByAccelerationId(Long accelerationId) {
        return candidateRepository.findByIdAccelerationId(accelerationId);
    }

}
