package com.quintomodulo.manipuladados.challenge.repository;

import com.quintomodulo.manipuladados.challenge.model.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    List<Challenge> findAll();

    @Query(value = "SELECT ch.id, ch.name, ch.slug, ch.created_at FROM challenge as ch " +
            "INNER JOIN acceleration as ac " +
            "ON (ch.id = ac.challenge_id) " +
            "INNER JOIN candidate as ca " +
            "ON (ac.id = ca.acceleration_id) " +
            "WHERE ca.acceleration_id = :accelerationId AND " +
            "ca.user_id = :userId", nativeQuery = true)
    List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId,
                                                  @Param("userId") Long userId);
}
