package com.endpoints.endpoints.repository;

import com.endpoints.endpoints.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);

    List<Company> findByCandidatesIdUserId(@Param("userId") Long userId);

}
