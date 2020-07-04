<%@ page import="java.time.LocalTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Busy Cat</title>
    <link href="resources/css/stylePage.css" rel="stylesheet">
</head>
<body>
<div class="layout">
<div class="leftPart"> <p></p>
<%
    String hello = "Mur-Mur! <br/> Let's work, " + session.getAttribute("user_nickname") +"!";
%>

<div class="catPic">
    <h2><%=hello%></h2>
    <img src="resources/images/busycat2.png" alt="Cat"
          width="200" height="200"> <br>
    <p><input type="button" onclick="setAddTaskVisible()" value="New Task" class="submitButtonNewTask"></p>
    <p><input type="button" onclick="setAddGoalVisible()" value="New Goal" class="submitButtonNewTask">
</div>

</div>

<div class="middlePart">
    <section>
    <form action="tasks/" id="newTask" name="newTask" method="post" style="visibility:hidden">
        <p><input type="text" maxlength="50" name="title" placeholder="Task Title" class="titleField"  autofocus></p>
        <p><textarea maxlength="150" name="description" placeholder="Description" class="descField" ></textarea></p>
        <p><input type="submit" value="Add Task" class="submitButton"></p>
    </form>
    </section>
    <section>
        <form action="tasks/" id="newGoal" name="newTask" method="post" style="visibility:hidden">
            <p><input type="text" maxlength="50" name="title" placeholder="Goal Title" class="titleField"  autofocus></p>
            <p><textarea maxlength="150" name="description" placeholder="Description" class="descField" ></textarea></p>
            <p><input type="submit" value="Add Goal" class="submitButton"></p>
        </form>
    </section>

</div>

<div class="rightPart">
    <%
        out.print("Task description:");
    %>

</div>
</div>
<script type="text/javascript">
    var docElementTask = document.getElementById('newTask')
    var docElementGoal = document.getElementById('newGoal')

    function setAddTaskVisible() {
        docElementTask = document.getElementById('newTask')
        docElementGoal = document.getElementById('newGoal')
        if (docElementTask.style.visibility === 'hidden') {
            docElementTask.style.visibility = 'visible';
            docElementGoal.style.visibility = 'hidden';
        } else {
            docElementTask.style.visibility = 'hidden';
        }
    }
    function setAddGoalVisible() {
        // var docElement = document.getElementById('newGoal')
        if (docElementGoal.style.visibility === 'hidden') {
            docElementTask.style.visibility = 'hidden';
            docElementGoal.style.visibility = 'visible';

        } else {
            docElementGoal.style.visibility = 'hidden';
        }
    }
</script>
</body>
</html>