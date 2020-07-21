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

    @Query(value = "SELECT su.user_id, su.challenge_id, su.score, su.created_at " +
            "FROM submission as su " +
            "INNER JOIN challenge as ch " +
            "ON (su.challenge_id = ch.id) " +
            "INNER JOIN acceleration as ac " +
            "ON (ch.id = ac.challenge_id) " +
            "WHERE ch.id = :challengeId AND " +
            "ac.id = :accelerationId", nativeQuery = true)
    List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,
                                                        @Param("accelerationId") Long accelerationId);

}
