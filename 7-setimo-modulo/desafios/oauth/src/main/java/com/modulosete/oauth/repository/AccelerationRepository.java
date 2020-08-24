package com.modulosete.oauth.repository;

import com.modulosete.oauth.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    List<Acceleration> findByCandidatesIdCompanyId(Long companyId);

}
