package br.com.quartodesafio.bdrelacional.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class Submission {

    @EmbeddedId
    private SubmissionIdentity submissionIdentity;

    @Column(nullable = false)
    private float score;

    @Column(nullable = false)
    private Timestamp created_at;

    public SubmissionIdentity getSubmissionIdentity() {
        return submissionIdentity;
    }

    public void setSubmissionIdentity(SubmissionIdentity submissionIdentity) {
        this.submissionIdentity = submissionIdentity;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}
