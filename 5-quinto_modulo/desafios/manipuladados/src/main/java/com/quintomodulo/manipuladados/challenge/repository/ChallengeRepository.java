package com.quintomodulo.manipuladados.challenge.repository;

import com.quintomodulo.manipuladados.challenge.model.Challenge;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

    List<Challenge> findAll();

}
