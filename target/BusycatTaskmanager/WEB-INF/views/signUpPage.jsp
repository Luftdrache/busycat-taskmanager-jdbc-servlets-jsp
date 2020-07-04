<%--
  Created by IntelliJ IDEA.
  User: Julia
  Date: 6/28/2020
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign Up</title>
    <link href="resources/css/stylePage.css" rel="stylesheet">
</head>
<body>
<p></p><h2>Start with Busy Cat!</h2>
<div><img src="resources/images/catpic.jpg" alt="Cat"
          weight="145" height="150"></div>

<form action="registration" method="post">
    <p><input maxlength="50" name="nickname" placeholder="Nickname" class="textField"  autofocus></p>
    <p><input maxlength="70" name="email" placeholder="Email" class="emailField"></p>
    <p><input type="password" maxlength="30" name="password"  placeholder="Password" class="passField"></p>
    <p><input type="submit" value="Get started" class="submitButton"></p>
</form>

Have an account already? <a href="<%=request.getContextPath() + "/index.jsp"%>">Sign in</a>

<h3 style="color:tomato;">${warning}</h3>


</body>
</html>
