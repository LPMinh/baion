package com.example.onthi3.frontend.controller;

import java.io.*;

import com.example.onthi3.frontend.model.CandidateModel;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "controlservlet", value = "/control-serlet")
public class HelloServlet extends HttpServlet {
    private String action;

    public void init() {

    }
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        action=request.getParameter("action");
        if(action.equals("filter")){
            CandidateModel model=new CandidateModel();
            model.getFilterCandidate(request,response);
        } if(action.equals("filterByName")){
            CandidateModel model=new CandidateModel();
            model.getNameCandidate(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        action=req.getParameter("action");

    }
}