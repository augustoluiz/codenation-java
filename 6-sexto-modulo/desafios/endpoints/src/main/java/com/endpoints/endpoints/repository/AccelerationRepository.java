package com.endpoints.endpoints.repository;

import com.endpoints.endpoints.entity.Acceleration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccelerationRepository extends JpaRepository<Acceleration, Long> {

    @Query(value = "SELECT * FROM ACCELERATION AS ACC\n" +
            "INNER JOIN CANDIDATE AS CAN\n" +
            "ON (ACC.ID = CAN.ACCELERATION_ID)\n" +
            "INNER JOIN COMPANY AS COM\n" +
            "ON (CAN.COMPANY_ID = COM.ID)\n" +
            "WHERE COM.ID = :companyId", nativeQuery = true)
    List<Acceleration> findByCandidatesIdCompanyId(@Param("companyId") Long companyId);

}
