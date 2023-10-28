package com.example.onthi3.frontend.model;

import com.example.onthi3.backend.model.Candidate;
import com.example.onthi3.backend.repository.CandidateRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

public class CandidateModel {
    CandidateRepository candidateRepository;
    public CandidateModel(){
        candidateRepository=new CandidateRepository();
    }
    public void getFilterCandidate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int role=Integer.parseInt(req.getParameter("role"));
        List<Candidate> list= candidateRepository.getCandidateByRole(role);
        req.setAttribute("cans",list);
        req.getRequestDispatcher("report1.jsp").forward(req,resp);
    }

    public void getNameCandidate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("name");
        List<Candidate> list= candidateRepository.getCandidateByCompanyName(name);
        request.setAttribute("cans",list);
        request.getRequestDispatcher("report3.jsp").forward(request,response);
    }
}
