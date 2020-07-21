package com.quintomodulo.manipuladados.user.repository;

import com.quintomodulo.manipuladados.user.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    @Query(value = "SELECT * FROM users as us\n" +
            "INNER JOIN candidate as ca\n" +
            "on (us.id = ca.user_id)\n" +
            "INNER JOIN acceleration as ac\n" +
            "on (ca.acceleration_id = ac.id)\n" +
            "where ac.name like'%:accelerationName%'", nativeQuery = true)
    List<User> findByAccelerationName(@Param("accelerationName") String accelerationName);

    @Query(value = "SELECT * FROM users as us\n" +
            "INNER JOIN candidate as ca\n" +
            "on (us.id = ca.user_id)\n" +
            "INNER JOIN company as co\n" +
            "on (ca.company_id = co.id)\n" +
            "where co.id = :companyId\n", nativeQuery = true)
    List<User> findByCompanyId(@Param("companyId") Long companyId);

}
