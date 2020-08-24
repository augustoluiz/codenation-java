package com.modulosete.oauth.repository;

import com.modulosete.oauth.entity.Candidate;
import com.modulosete.oauth.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    Optional<Candidate> findByIdUserIdAndIdCompanyIdAndIdAccelerationId(Long userId, Long companyId, Long accelerationId);

    List<Candidate> findByIdCompanyId(Long companyId);

    List<Candidate> findByIdAccelerationId(Long accelerationId);

}

