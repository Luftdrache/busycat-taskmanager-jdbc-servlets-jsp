<%@ page import="java.time.LocalTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<p></p>
<%
    String nickname = (String) session.getAttribute("user_nickname");
    out.println("Mur-Mur, busy " + nickname + "!\n");
    LocalTime now = LocalTime.now();
    out.println(String.format("Current server time: %tR", now));
%>
</body>
</html>
