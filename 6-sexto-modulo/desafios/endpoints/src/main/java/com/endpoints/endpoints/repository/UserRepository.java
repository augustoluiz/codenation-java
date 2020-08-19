package com.endpoints.endpoints.repository;

import com.endpoints.endpoints.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM USERS AS USE " +
            "INNER JOIN CANDIDATE AS CAN " +
            "ON (USE.ID = CAN.USER_ID) " +
            "INNER JOIN ACCELERATION AS ACC " +
            "ON (CAN.ACCELERATION_ID = ACC.ID) " +
            "WHERE ACC.NAME LIKE %:accelerationName%", nativeQuery = true)
    List<User> findByCandidatesIdAccelerationName(@Param("accelerationName") String accelerationName);

    @Query(value = "SELECT * FROM USERS AS USE " +
            "INNER JOIN CANDIDATE AS CAN " +
            "ON (USE.ID = CAN.USER_ID) " +
            "INNER JOIN COMPANY AS COM " +
            "ON (CAN.COMPANY_ID = COM.ID) " +
            "WHERE COM.ID = :companyId", nativeQuery = true)
    List<User> findByCandidatesIdCompanyId(@Param("companyId") Long companyId);
}
