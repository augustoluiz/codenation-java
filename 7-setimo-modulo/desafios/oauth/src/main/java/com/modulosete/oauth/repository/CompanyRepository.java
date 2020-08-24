package com.modulosete.oauth.repository;

import com.modulosete.oauth.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    List<Company> findDistinctByCandidatesIdAccelerationId(Long accelerationId);

    List<Company> findByCandidatesIdUserId(Long userId);

}
