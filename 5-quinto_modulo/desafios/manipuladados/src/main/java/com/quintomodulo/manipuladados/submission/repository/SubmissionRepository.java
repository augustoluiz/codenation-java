package com.quintomodulo.manipuladados.submission.repository;

import com.quintomodulo.manipuladados.submission.model.Submission;
import com.quintomodulo.manipuladados.submission.model.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    List<Submission> findAll();

    @Query(value = "SELECT score FROM submission " +
            "WHERE challenge_id = :challengeId " +
            "order by score desc LIMIT 1", nativeQuery = true)
    BigDecimal findHigherScoreByChallengeId(@Param("challengeId") Long challengeId);

    @Query(value = "select su.user_id, " +
            "       su.challenge_id, " +
            "       su.score, " +
            "       su.created_at " +
            "from submission as su " +
            "INNER JOIN users as us " +
            "ON (su.user_id = us.id) " +
            "INNER JOIN candidate as ca " +
            "ON (us.id = ca.user_id) " +
            "INNER JOIN acceleration as ac " +
            "ON (ca.acceleration_id = ac.id) " +
            "INNER JOIN challenge as ch " +
            "ON (ac.challenge_id = ch.id) " +
            "WHERE ch.id = :challengeId AND " +
            "ac.id = :accelerationId", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,
                                                        @Param("accelerationId") Long accelerationId);

}
