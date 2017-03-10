<%--
  Created by IntelliJ IDEA.
  User: kovalchuk
  Date: 06.03.2017
  Time: 20:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit userId</title>
</head>
<body>
    <form method="post" action="users">
        <jsp:useBean id="userId" scope="request" class="org.itstep.myWebApp.model.User"/>

        <input type="hidden" name="id" value="${userId.id}">

        <dl>Name:</dl>
        <dt><input type="text" name="name" value="${userId.name}"></dt>

        <dl>Last name:</dl>
        <dt><input type="text" name="lastname" value="${userId.lastname}"></dt>

        <dl>City:</dl>
        <dt><input type="text" name="city" value="${userId.city}"></dt>

        <dl>Email:</dl>
        <dt><input type="email" name="email" value="${userId.email}"></dt>

        <button type="submit">SAVE</button>
    </form>
</body>
</html>
