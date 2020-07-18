package com.quintomodulo.manipuladados.submission.repository;

import com.quintomodulo.manipuladados.submission.model.Submission;
import com.quintomodulo.manipuladados.submission.model.SubmissionId;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

    List<Submission> findAll();

}
