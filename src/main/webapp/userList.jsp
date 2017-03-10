<%@ page import="org.itstep.myWebApp.model.User" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User list</title>
</head>
<body>
<table cellspacing="0" cellpadding="5" border="1">
    <thead>
    <tr>
        <td>Name</td>
        <td>Last name</td>
        <td>City</td>
        <td>Email</td>
        <td></td>
        <td></td>
    </tr>
    </thead>

  <%--  // simple java realization
    <%
        for (User userId : (List<User>) request.getAttribute("userList")) {
        %>
        <tr>
            <td><%=userId.getName()%></td>
            <td><%=userId.getLastname()%></td>
            <td><%=userId.getCity()%></td>
            <td><%=userId.getEmail()%></td>
            <td></td>
        </tr>
        <%
        }
    %>--%>

    <%-- jstl realization - без костылей :)--%>
    <c:forEach items="${userList}" var="userId">
        <tr>
            <jsp:useBean id="userId" class="org.itstep.myWebApp.model.User"/>
            <td>${userId.name}</td>
            <td>${userId.lastname}</td>
            <td>${userId.city}</td>
            <td>${userId.email}</td>
            <td><a href="users?action=update&id=${userId.id}">UPDATE</a> </td>
            <td><a href="users?action=delete&id=${userId.id}">DELETE</a></td>
        </tr>
    </c:forEach>
</table>
<a href="users?action=create">Create new one</a>
</body>
</html>
