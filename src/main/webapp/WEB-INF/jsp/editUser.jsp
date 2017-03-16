<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>
    <form method="post" action="./">
        <jsp:useBean id="user" scope="request" class="org.itstep.myWebApp.model.User"/>

        <input type="hidden" name="id" value="${user.id}">

        <dl>Name:</dl>
        <dt><input type="text" name="name" value="${user.name}"></dt>

        <dl>Last name:</dl>
        <dt><input type="text" name="lastname" value="${user.lastname}"></dt>

        <dl>City:</dl>
        <dt><input type="text" name="city" value="${user.city}"></dt>

        <dl>Email:</dl>
        <dt><input type="email" name="email" value="${user.email}"></dt>

        <button type="submit">SAVE</button>
    </form>
</body>
</html>
