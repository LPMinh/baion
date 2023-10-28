package com.example.onthi3.backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "can_id")
    private Long id;
    @Column(columnDefinition = "varchar(15)")
    private String phone;
    @Column(columnDefinition = "varchar(255)")
    private String email;
    @Column(name = "full_name",columnDefinition = "varchar(255)")
    private String fullName;
    @OneToMany(mappedBy = "candidate",fetch = FetchType.LAZY,cascade = CascadeType.ALL)

    private List<Experience> experiences=new ArrayList<Experience>();

    public Candidate(Long id, String phone, String email, String fullName, List<Experience> experiences) {
        this.id = id;
        this.phone = phone;
        this.email = email;
        this.fullName = fullName;
        this.experiences = experiences;
    }

    public Candidate() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }
}
