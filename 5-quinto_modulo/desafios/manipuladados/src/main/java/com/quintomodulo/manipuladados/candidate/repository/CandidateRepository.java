package com.quintomodulo.manipuladados.candidate.repository;

import com.quintomodulo.manipuladados.candidate.model.Candidate;
import com.quintomodulo.manipuladados.candidate.model.CandidateId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {

    List<Candidate> findAll();

}
