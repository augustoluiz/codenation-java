package com.endpoints.endpoints.repository;

import com.endpoints.endpoints.entity.Candidate;
import com.endpoints.endpoints.entity.CandidateId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, CandidateId> {

    @Query(value = "SELECT DISTINCT * FROM CANDIDATE \n" +
            "WHERE USER_ID = :userId \n" +
            "AND COMPANY_ID = :companyId\n" +
            "AND ACCELERATION_ID = :accelerationId", nativeQuery = true)
    Optional<Candidate> findByIdUserIdAndIdCompanyIdAndIdAccelerationId(@Param("userId") Long userId,
                                                                        @Param("companyId") Long companyId,
                                                                        @Param("accelerationId") Long accelerationId);

    @Query(value = "SELECT * FROM CANDIDATE\n" +
            "WHERE COMPANY_ID = :companyId", nativeQuery = true)
    List<Candidate> findByIdCompanyId(@Param("companyId") Long companyId);

    @Query(value = "SELECT * FROM CANDIDATE\n" +
            "WHERE ACCELERATION_ID = :accelerationId", nativeQuery = true)
    List<Candidate> findByIdAccelerationId(@Param("accelerationId") Long accelerationId);

}

