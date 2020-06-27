<%@ page import="java.time.LocalTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body bgcolor=#daa520>
Authorization was successfull <p>
<%
    LocalTime now = LocalTime.now();
    out.println(String.format("Current server time: %tR", now));
%>

</body>
</html>
