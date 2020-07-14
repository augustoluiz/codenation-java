package br.com.quartodesafio.bdrelacional.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.List;

@Entity
public class Challenge {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotBlank
    @Column(length = 100, nullable = false)
    private String name;

    @NotBlank
    @Column(length = 50, nullable = false)
    private String slug;

    @Column(nullable = false)
    private Timestamp created_at;

    @OneToMany
    private List<Acceleration> accelerations;

    @OneToMany
    private List<Submission> submissions;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
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
}
