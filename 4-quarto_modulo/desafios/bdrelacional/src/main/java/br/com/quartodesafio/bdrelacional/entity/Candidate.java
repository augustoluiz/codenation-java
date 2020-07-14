package br.com.quartodesafio.bdrelacional.entity;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.sql.Timestamp;

@Entity
public class Candidate {

    @EmbeddedId
    private CandidateIdentity candidateIdentity;

    @Column(nullable = false)
    private int status;

    @Column(nullable = false)
    private Timestamp created_at;

    public CandidateIdentity getCandidateIdentity() {
        return candidateIdentity;
    }

    public void setCandidateIdentity(CandidateIdentity candidateIdentity) {
        this.candidateIdentity = candidateIdentity;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

}
