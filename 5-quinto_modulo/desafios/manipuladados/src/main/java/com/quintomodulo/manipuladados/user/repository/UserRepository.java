package com.quintomodulo.manipuladados.user.repository;

import com.quintomodulo.manipuladados.user.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findAll();

    @Query(value = "select * from users as us" +
            "INNER JOIN candidate as ca" +
            "on (us.id = ca.user_id)" +
            "INNER JOIN acceleration as ac" +
            "on (ca.acceleration_id = ac.id)" +
            "where ac.name like'%:accelerationName%';\n", nativeQuery = true)
    List<User> findByAccelerationName(@Param("accelerationName") String accelerationName);

    @Query(value = "select * from users as us" +
            "INNER JOIN candidate as ca" +
            "on (us.id = ca.user_id)" +
            "INNER JOIN company as co" +
            "on (ca.company_id = co.id)" +
            "where co.id = :companyId;", nativeQuery = true)
    List<User> findByCompanyId(@Param("companyId") Long companyId);

}
