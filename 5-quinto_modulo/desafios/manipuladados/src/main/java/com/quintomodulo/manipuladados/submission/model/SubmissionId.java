package com.quintomodulo.manipuladados.submission.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quintomodulo.manipuladados.challenge.model.Challenge;
import com.quintomodulo.manipuladados.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Embeddable;
import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class SubmissionId implements Serializable {

    @ManyToOne
    @JsonIgnore
    private Challenge challenge;

    @ManyToOne
    @JsonIgnore
    private User user;

    public Challenge getChallenge() {
        return challenge;
    }

    public void setChallenge(Challenge challenge) {
        this.challenge = challenge;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "SubmissionId{" +
                "challenge=" + challenge +
                ", user=" + user +
                '}';
    }
}
