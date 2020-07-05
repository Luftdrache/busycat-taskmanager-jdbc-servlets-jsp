<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Busy Cat</title>
    <link href="resources/css/stylePage.css" rel="stylesheet">
    <link rel="shortcut icon" href="resources/images/user.png" type="image/png">
</head>
<body>
<div class="layout">
    <div class="leftPart"><p></p>
        <%
            String hello = "Mur-Mur! <br/> Let's work, " + session.getAttribute("user_nickname") + "!";
        %>

        <div class="catPic">
            <h2><%=hello%>
            </h2>
            <img src="resources/images/busycat2.png" alt="Cat"
                 width="200" height="200"> <br>
            <p><input type="button" onclick="setAddTaskVisible()" value="New Task" class="submitButtonNewTask"></p>
            <p><input type="button" onclick="setAddGoalVisible()" value="New Goal" class="submitButtonNewTask">
        </div>

    </div>

    <div class="middlePart" align="center">
<%--        <c:if test="${empty listOfTasks}">--%>
<%--            <p></p>--%>
<%--            <c:out value="You don't have any tasks yet"></c:out>--%>
<%--        </c:if>--%>

            <c:forEach var="task" items="${listOfTasks}">
                <table border-spacing="0, 0" rules="rows">
                    <tr style="color:${task.task_status == "IN_PROGRESS" ? 'black':'#bdbebd'};font-weight:normal">
                        <form action="tasks?action=change_status&id=${task.task_id}"  method="post">
                            <input type="hidden" name="task_id" value="${task.task_id}">
                        <td><input type="checkbox" name="status" value="${task.task_status}" onchange="this.form.submit()"/>
                            <c:out value="${task.task_title}"/></td>
                        </form>
                        <td><c:out value="${task.task_description}"/></td>
                        <td style="color:${task.task_status == "IN_PROGRESS" ?  'firebrick' : 'forestgreen'};
                                font-weight:${task.task_status == "IN_PROGRESS" ?  'bold' : 'normal'}">
                            <c:out value="${fn:toLowerCase(task.task_status)}"/>
                        </td>
                        <td>
                            <form action="tasks?action=edit&id=${task.task_id}" method="post" style="display:inline-block;
                            margin-bottom: 5%"/>
                            <input type="submit" value="Edit" />
<%--                            <a href="tasks?action=edit&id=<c:out value='${task.task_id}' />">Edit</a>--%>
<%--                            <a href="tasks?action=delete&id=<c:out value='${task.task_id}' />">Delete</a>--%>
                            </form>
                            <form action="tasks?action=delete&id=${task.task_id}" method="post" style="display:inline-block;
                           margin-bottom: 5%"/>
                            <input type="submit" value="Delete" />
                            </form>

                        </td>
                    </tr>
                </table>
            </c:forEach>

        <section>
            <form action="tasks?action=new_goal" id="newGoal" name="newGoal" method="post" style="visibility:hidden">
                <p><input type="text" maxlength="50" name="title" placeholder="Goal Title" class="titleField" autofocus>
                </p>
                <p><textarea maxlength="150" name="description" placeholder="Description" class="descField"></textarea>
                </p>
                <p><input type="submit" value="Add Goal" class="submitButton"></p>
            </form>
        </section>
        <section>
            <form action="tasks?action=new_task" id="newTask" name="newTask" method="post" style="visibility:hidden">
                <p><input type="text" maxlength="50" name="title" placeholder="Task Title" class="titleField" autofocus>
                </p>
                <p><textarea maxlength="150" name="description" placeholder="Description" class="descField"></textarea>
                </p>
                <p><input type="submit" value="Add Task" class="submitButton"></p>
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
        if (docElementGoal.style.visibility === 'hidden') {
            docElementTask.style.visibility = 'hidden';
            docElementGoal.style.visibility = 'visible';

        } else {
            docElementGoal.style.visibility = 'hidden';
        }
    }

    function showDescription(el) {


    }

</script>
</body>
</html>