package com.example.onthi3.backend.config;

import com.example.onthi3.backend.model.Candidate;
import com.example.onthi3.backend.model.Experience;
import com.example.onthi3.backend.model.Roles;
import com.example.onthi3.backend.repository.CandidateRepository;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.time.LocalDate;
import java.util.ArrayList;

@WebListener

public class CreateData implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        CandidateRepository candidateRepository=new CandidateRepository();
        Candidate can1=new Candidate(1l,"09861414123","lyminh@gmail.com","lyminh1",new ArrayList<>());
        Candidate can2=new Candidate(2l,"09861414123","lyminh@gmail.com","lyminh2",new ArrayList<>());
        Candidate can3=new Candidate(3l,"09861414123","lyminh@gmail.com","lyminh3",new ArrayList<>());
        Experience exp1=new Experience(1l, LocalDate.of(2022,1,1),"lam", Roles.STAFF,"FPT",LocalDate.of(2023,1,1),can1);
        Experience exp2=new Experience(2l, LocalDate.of(2022,1,1),"lam", Roles.MANAGER,"FPT",LocalDate.of(2023,1,1),can1);
        Experience exp3=new Experience(3l, LocalDate.of(2022,1,1),"lam", Roles.ADMiNISTRATION,"FPT",LocalDate.of(2023,1,1),can1);
        Experience exp4=new Experience(4l, LocalDate.of(2022,1,1),"lam", Roles.STAFF,"FPT",LocalDate.of(2023,1,1),can2);
        Experience exp5=new Experience(5l, LocalDate.of(2022,1,1),"lam", Roles.MANAGER,"FPT",LocalDate.of(2023,1,1),can2);
        Experience exp6=new Experience(6l, LocalDate.of(2022,1,1),"lam", Roles.MANAGER,"FPT",LocalDate.of(2023,1,1),can2);
        Experience exp7=new Experience(7l, LocalDate.of(2022,1,1),"lam", Roles.EXECUTIVE,"FPT",LocalDate.of(2023,1,1),can3);
        Experience exp8=new Experience(8l, LocalDate.of(2022,1,1),"lam", Roles.MANAGER,"FPT",LocalDate.of(2023,1,1),can3);
        Experience exp9=new Experience(9l, LocalDate.of(2022,1,1),"lam", Roles.ADMiNISTRATION,"FPT",LocalDate.of(2023,1,1),can3);
        can1.getExperiences().add(exp1);
        can1.getExperiences().add(exp2);
        can1.getExperiences().add(exp3);
        can2.getExperiences().add(exp4);
        can2.getExperiences().add(exp5);
        can2.getExperiences().add(exp6);
        can3.getExperiences().add(exp7);
        can3.getExperiences().add(exp8);
        can3.getExperiences().add(exp9);
        candidateRepository.addCandidate(can1);
        candidateRepository.addCandidate(can2);
        candidateRepository.addCandidate(can3);
    }
}
