package com.quintomodulo.manipuladados.company.repository;

import com.quintomodulo.manipuladados.company.model.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository  extends CrudRepository<Company, Long> {

    List<Company> findAll();

    @Query(value = "SELECT DISTINCT co.id, co.name, co.slug, co.created_at FROM company as co " +
            "INNER JOIN candidate as ca " +
            "ON (co.id = ca.company_id) " +
            "INNER JOIN acceleration as ac " +
            "ON (ca.acceleration_id = ac.id) " +
            "WHERE ac.id = :accelerationId", nativeQuery = true)
    List<Company> findbyAccelerationId(@Param("accelerationId") Long accelerationId);

    @Query(value = "SELECT co.id, co.name, co.slug, co.created_at FROM company as co " +
            "INNER JOIN candidate as ca " +
            "ON (co.id = ca.company_id) " +
            "INNER JOIN users as us " +
            "ON (ca.user_id = us.id) " +
            "WHERE us.id = :userId", nativeQuery = true)
    List<Company> findByUserId(@Param("userId") Long userId);
}
