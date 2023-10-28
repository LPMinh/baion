<%@ page import="com.example.onthi3.backend.repository.CandidateRepository" %>
<%@ page import="com.example.onthi3.backend.model.Candidate" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: lyphi
  Date: 10/28/2023
  Time: 10:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="control-serlet" method="get">
    <select name="role">
        <option value="0">ADMINISTRATION</option>
        <option value="1">STAFF</option>
        <option value="2">MANAGER</option>
        <option value="3">EXECUTIVE</option>

    </select>
    <input type="hidden" name="action" value="filter">
    <button type="submit">VIEW</button>
</form>
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

        List<Candidate> cans= (List<Candidate>) request.getAttribute("cans");
        if(cans==null){
            cans=new ArrayList<Candidate>();
        }
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
</body>
</html>
