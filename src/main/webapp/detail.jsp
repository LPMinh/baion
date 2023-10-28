<%@ page import="com.example.onthi3.backend.repository.CandidateRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.onthi3.backend.model.Candidate" %>
<%@ page import="com.example.onthi3.backend.model.Experience" %><%--
  Created by IntelliJ IDEA.
  User: lyphi
  Date: 10/28/2023
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <Table>
        <thead>
        <tr>
            <th>
                id
            </th>
            <th>name</th>
            <th>email</th>
            <th>phone</th>
            <th>detail</th>
        </tr>
        </thead>
        <tbody>
        <%
            CandidateRepository candidateRepository=new CandidateRepository();
            candidateRepository.getAllCandidate();
            Long id=Long.parseLong(request.getParameter("id"));
            Candidate can=candidateRepository.findByID(id);
           List<Experience> exps=candidateRepository.findExperienceBYID(id);


        %>
        <tr>
            <td><%=can.getId()%></td>
            <td><%=can.getFullName()%></td>
            <td><%=can.getEmail()%></td>
            <td><%=can.getPhone()%></td>
            <td><a href="detail.jsp?id=<%=can.getId()%>">VIEW</a></td>
        </tr>

        </tbody>
    </Table>
    <Table>
        <thead>
        <tr>
            <th>
                id
            </th>
            <th>company</th>
            <th>toDate</th>
            <th>fromDate</th>
            <th>work_desc</th>
            <th>role</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(Experience exp:exps){
        %>
        <tr>
            <td><%=exp.getId()%></td>
            <td><%=exp.getCompanyName()%></td>
            <td><%=exp.getToDate()%></td>
            <td><%=exp.getFromDate()%></td>
            <td><%=exp.getWordDescription()%>/td>
            <td><%=exp.getRole().name()%>/td>
        </tr>
    <%}%>
        </tbody>
    </Table>
</head>
<body>

</body>
</html>
