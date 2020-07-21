package com.quintomodulo.manipuladados.challenge.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.quintomodulo.manipuladados.acceleration.model.Acceleration;
import com.quintomodulo.manipuladados.submission.model.Submission;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@EntityListeners(AuditingEntityListener.class)
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    @Size(max = 100)
    private String name;

    @Column
    @NotNull
    @Size(max = 50)
    private String slug;

    @OneToMany(mappedBy = "challenge")
    @JsonIgnore
    private List<Acceleration> accelerations;

    @OneToMany(mappedBy = "id.challenge")
    @JsonIgnore
    private List<Submission> submissions;

    @CreatedDate
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public List<Acceleration> getAccelerations() {
        return accelerations;
    }

    public void setAccelerations(List<Acceleration> accelerations) {
        this.accelerations = accelerations;
    }

    public List<Submission> getSubmissions() {
        return submissions;
    }

    public void setSubmissions(List<Submission> submissions) {
        this.submissions = submissions;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Challenge{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", slug='" + slug + '\'' +
                ", accelerations=" + accelerations +
                ", submissions=" + submissions +
                ", createdAt=" + createdAt +
                '}';
    }
}
