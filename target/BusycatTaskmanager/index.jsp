<%@ page import="com.taskmanager.busycat.util.DBCreation" %>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Busy Cat</title>
    <link href="resources/css/stylePage.css" rel="stylesheet">
</head>

<body>

<p></p><h2>Plan your life with Busy Cat!</h2>
<div><img src="resources/images/catpic.jpg" alt="Cat"
          weight="145" height="150"></div>


<form action="authorization" method="post">
    <p><input maxlength="70" name="login" placeholder="Email" class="textField"  autofocus></p>
    <p><input type="password" maxlength="30" name="password"  placeholder="Password" class="passField"></p>
    <p><input type="submit" value="Sign in" class="submitButton"></p>
</form>


<form action="registration" method="get">
    <p><input type="submit" value="Sign up" class="submitButton"></p>
</form>

<h3 style="color:tomato;">${warning}</h3>

</body>
</html>
