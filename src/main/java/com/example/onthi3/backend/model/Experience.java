package com.example.onthi3.backend.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
@Entity
@Table(name = "experience")
public class Experience implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "exp_id")
    private Long id;
    @Column(name = "from_date",columnDefinition = "date")
    private LocalDate fromDate;
    @Column(name="work_desc",columnDefinition = "varchar(400)")
    private String wordDescription;
    @Enumerated(EnumType.ORDINAL)
    private Roles role;
    @Column(name = "company",columnDefinition = "varchar(255)")
    private String companyName;
    @Column(name = "to_date",columnDefinition = "date")
    private LocalDate toDate;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name = "can_id")
    private Candidate candidate;

    public Experience() {
    }

    public Experience(Long id, LocalDate fromDate, String wordDescription, Roles role, String companyName, LocalDate toDate, Candidate candidate) {
        this.id = id;
        this.fromDate = fromDate;
        this.wordDescription = wordDescription;
        this.role = role;
        this.companyName = companyName;
        this.toDate = toDate;
        this.candidate = candidate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public String getWordDescription() {
        return wordDescription;
    }

    public void setWordDescription(String wordDescription) {
        this.wordDescription = wordDescription;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
