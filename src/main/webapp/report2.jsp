<%@ page import="com.example.onthi3.backend.repository.CandidateRepository" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.onthi3.backend.model.Candidate" %><%--
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
            List<Candidate> cans=candidateRepository.selectCandidateUseGmail();
            for (Candidate can:cans){
        %>
        <tr>
            <td><%=can.getId()%></td>
            <td><%=can.getFullName()%></td>
            <td><%=can.getEmail()%></td>
            <td><%=can.getPhone()%></td>
            <td><a href="detail.jsp?id=<%=can.getId()%>">VIEW</a></td>


        </tr>
        <%}%>
        </tbody>
    </Table>
</head>
<body>

</body>
</html>
