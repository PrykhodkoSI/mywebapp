<%@ page import="java.time.format.DateTimeFormatter" %><%--
  Created by IntelliJ IDEA.
  User: student
  Date: 10.03.2017
  Time: 19:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Mails</title>
</head>
<body>

<table cellspacing="0" cellpadding="5" border="1">
    <thead>
    <tr>
        <td>Name</td>
        <td>To</td>
        <td>Date</td>
        <td>Text</td>
        <%--<td></td>--%>
        <%--<td></td>--%>
    </tr>
    </thead>
    <c:forEach items="${mailList}" var="mailId">
        <tr>
            <jsp:useBean id="mailId" class="org.itstep.myWebApp.model.Mail"/>
            <td>${mailId.name}</td>
            <td>${mailId.to}</td>
            <td><%= mailId.getCreated().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")) %><%--${mailId.created}--%></td>
            <td>${mailId.text}</td>
            <%--<td><a href="users?action=update&id=${mailId.id}">UPDATE</a> </td>--%>
            <%--<td><a href="users?action=delete&id=${mailId.id}">DELETE</a></td>--%>
        </tr>
    </c:forEach>
</table>

</body>
</html>
