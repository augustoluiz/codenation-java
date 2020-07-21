package com.quintomodulo.manipuladados.candidate.service;

import com.quintomodulo.manipuladados.candidate.model.Candidate;
import com.quintomodulo.manipuladados.candidate.model.CandidateId;
import com.quintomodulo.manipuladados.generic_interface.ServiceInterface;

import java.util.List;
import java.util.Optional;

public interface CandidateServiceInterface extends ServiceInterface<Candidate> {

    List<Candidate> findAll();

    Optional<Candidate> findById(CandidateId id);

    Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByCompanyId(Long companyId);

    List<Candidate> findByAccelerationId(Long accelerationId);
}
