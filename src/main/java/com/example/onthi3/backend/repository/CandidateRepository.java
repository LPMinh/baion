package com.example.onthi3.backend.repository;

import com.example.onthi3.backend.model.Candidate;
import com.example.onthi3.backend.model.Experience;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CandidateRepository {
    private  EntityManager em;
    private EntityTransaction trans;
    private Logger logger= LoggerFactory.getLogger(this.getClass().getName());
    public CandidateRepository(){
        em= Persistence.createEntityManagerFactory("onthi3").createEntityManager();
        trans=em.getTransaction();
    }
    public boolean addCandidate(Candidate candidate){
        try{
            trans.begin();
            em.persist(candidate);
            trans.commit();
            return true;
        }catch (Exception e){
            logger.error(e.getMessage());
            return false;
        }
    }
    public List<Candidate> getAllCandidate(){
        try{
            trans.begin();
            List<Candidate> list=em.createNativeQuery("select * from candidate", Candidate.class).getResultList();
            trans.commit();
            return list;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public Candidate  findByID(long id){
        try{
            trans.begin();
            Candidate can = (Candidate) em.createNativeQuery("select * from candidate where can_id="+id+"", Candidate.class).getSingleResult();
            trans.commit();
            return can;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public List<Experience> findExperienceBYID(long id){
        try{
            trans.begin();
            List<Experience> list = em.createNativeQuery("select * from experience where can_id="+id+"", Experience.class).getResultList();
            trans.commit();
            return list;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }

    public List<Candidate> getCandidateByRole(int role) {
        try{
            trans.begin();
            List<Candidate> list=em.createNativeQuery("select a.* from candidate a join experience b on a.can_id=b.can_id where b.role="+role+" group by a.can_id", Candidate.class).getResultList();
            trans.commit();
            return list;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public List<Candidate> selectCandidateUseGmail(){
        try{
            trans.begin();
            List<Candidate> list=em.createNativeQuery("select * from candidate  where email like CONCAT ('%',?1,'%')", Candidate.class).setParameter(1,"gmail").getResultList();
            trans.commit();
            return list;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public List<Candidate> getCandidateByCompanyName(String nameCompany){
        try{
            trans.begin();
            List<Candidate> list=em.createNativeQuery("select a.* from candidate a join experience b on a.can_id =b.can_id  where company like CONCAT ('%',?1,'%')", Candidate.class).setParameter(1,nameCompany).getResultList();
            trans.commit();
            return list;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
    public List<Candidate> getCandidateUsedADMiN(){
        try{
            trans.begin();
            List<Candidate> list=em.createNativeQuery("select a.* from candidate a join experience b on a.can_id =b.can_id  where ROLE = 0", Candidate.class).getResultList();
            trans.commit();
            return list;
        }catch (Exception e){
            logger.error(e.getMessage());
            return null;
        }
    }
}
