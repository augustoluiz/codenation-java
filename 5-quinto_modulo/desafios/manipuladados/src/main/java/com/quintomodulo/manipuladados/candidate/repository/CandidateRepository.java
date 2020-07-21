package com.quintomodulo.manipuladados.candidate.repository;

import com.quintomodulo.manipuladados.candidate.model.Candidate;
import com.quintomodulo.manipuladados.candidate.model.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {

    List<Candidate> findAll();

    @Query(value = "SELECT * FROM candidate\n" +
            "WHERE user_id = :userId and\n" +
            "company_id = :companyId and\n" +
            "acceleration_id = :accelerationId", nativeQuery = true)
    Optional<Candidate> findById(@Param("userId") Long userId,
                                 @Param("companyId") Long companyId,
                                 @Param("accelerationId") Long accelerationId);


    @Query(value = "SELECT * FROM candidate\n" +
            "WHERE company_id = :companyId", nativeQuery = true)
    List<Candidate> findByCompanyId(@Param("companyId") Long companyId);


    @Query(value = "SELECT * FROM candidate\n" +
            "WHERE acceleration_id = :accelerationId", nativeQuery = true)
    List<Candidate> findByAccelerationId(@Param("accelerationId") Long accelerationId);
}
