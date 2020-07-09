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
<%--        <c:forEach var="goal" items="${listOfGoals}">--%>
<%--            <table border-spacing="0, 0" rules="rows">--%>
<%--                <tr style="color:${goal.goal_status == "IN_PROGRESS" ? 'black':'#bdbebd'};font-weight:normal">--%>
<%--                    <td width="5%"><img src="resources/images/goal.png" alt="" style="width: 30px; height:auto;"></td>--%>
<%--                    <form action="tasks?action=change_goal_status&goal_id=${goal.goal_id}" method="post">--%>
<%--                        <input type="hidden" name="goal_id" value="${goal.goal_id}">--%>
<%--                        <td width="30%"><input type="checkbox" name="goal_status" value="${goal.goal_status}"--%>
<%--                                   onchange="this.form.submit()"/>--%>
<%--                            <c:out value="${goal.goal_title}"/></td>--%>
<%--                    </form>--%>
<%--                    <td width="35%"><c:out value="${goal.goal_description}"/></td>--%>
<%--                    <td width="15%" style="color:${goal.goal_status == "IN_PROGRESS" ?  'firebrick' : 'forestgreen'};--%>
<%--                            font-weight:${goal.goal_status == "IN_PROGRESS" ?  'bold' : 'normal'}">--%>
<%--                        <c:out value="${fn:toLowerCase(goal.goal_status)}"/>--%>
<%--                    </td>--%>
<%--                    <td width="15%">--%>
<%--                            <button onclick="showActions()" class="listButton" >Actions</button>--%>
<%--                            <div id="drop-content" style="display: none">--%>
<%--                        <form action="tasks?action=edit_goal&goal_id=${goal.goal_id}" method="post"--%>
<%--                              style="display:inline-block; margin-bottom: 3%"/>--%>
<%--                        <input type="submit" value="Edit"/>--%>
<%--                        </form>--%>
<%--                        <form action="tasks?action=delete_goal&goal_id=${goal.goal_id}" method="post"--%>
<%--                              style="display:inline-block; margin-bottom: 3%"/>--%>
<%--                        <input type="submit" value="Delete"/>--%>
<%--                        </form>--%>
<%--                        <form action="tasks?action=add_subgoal&goal_id=${goal.goal_id}" method="post"--%>
<%--                              style="display:inline-block; margin-bottom: 3%"/>--%>
<%--                        <input type="submit" value="+Subgoal"/>--%>
<%--                        </form>--%>
<%--                        <form action="tasks?action=add_task&goal_id=${goal.goal_id}" method="post"--%>
<%--                              style="display:inline-block; margin-bottom: 3%"/>--%>
<%--                        <input type="submit" value="+Task"/>--%>
<%--                        </form>--%>
<%--                            </div>--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </table>--%>
<%--        </c:forEach>--%>


<%--        &lt;%&ndash; ***********       TASK!!!!!&ndash;%&gt;--%>
<%--        <c:forEach var="task" items="${listOfTasks}">--%>
<%--            <table border-spacing="0, 0" rules="rows">--%>
<%--                <tr style="color:${task.task_status == "IN_PROGRESS" ? 'black':'#bdbebd'};font-weight:normal">--%>
<%--                    <form action="tasks?action=change_task_status&id=${task.task_id}" method="post">--%>
<%--                        <input type="hidden" name="task_id" value="${task.task_id}">--%>
<%--                        <td width="30%" ><input type="checkbox" name="status" value="${task.task_status}"--%>
<%--                                   onchange="this.form.submit()" padding-left="5%"/>--%>
<%--                            <c:out value="${task.task_title}"/></td>--%>
<%--                    </form>--%>
<%--                    <td width="35%"><c:out value="${task.task_description}"/></td>--%>
<%--                    <td width="15%" style="color:${task.task_status == "IN_PROGRESS" ?  'firebrick' : 'forestgreen'};--%>
<%--                            font-weight:${task.task_status == "IN_PROGRESS" ?  'bold' : 'normal'}">--%>
<%--                        <c:out value="${fn:toLowerCase(task.task_status)}"/>--%>
<%--                    </td>--%>
<%--                    <td width="15%">--%>
<%--                            <button onclick="showActions()" class="listButton" >Actions</button>--%>
<%--                            <div id="drop-content" style="display: none">--%>
<%--                                <form action="tasks?action=edit&id=${task.task_id}" method="post"--%>
<%--                                      style="display:inline-block;"/>--%>
<%--                                <input type="submit" value="Edit"/>--%>
<%--                                </form>--%>
<%--                                <form action="tasks?action=delete&id=${task.task_id}" method="post"--%>
<%--                                      style="display:inline-block;"/>--%>
<%--                                <input type="submit" value="Delete"/>--%>
<%--                                </form>--%>
<%--                            </div>--%>
<%--                            &lt;%&ndash;                        <form action="tasks?action=edit&id=${task.task_id}" method="post"&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                              style="display:inline-block; margin-bottom: 3%"/>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                        <input type="submit" value="Edit"/>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                        </form>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                        <form action="tasks?action=delete&id=${task.task_id}" method="post"&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                              style="display:inline-block; margin-bottom: 3%"/>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                        <input type="submit" value="Delete"/>&ndash;%&gt;--%>
<%--                            &lt;%&ndash;                        </form>&ndash;%&gt;--%>
<%--                    </td>--%>
<%--                </tr>--%>
<%--            </table>--%>
<%--        </c:forEach>--%>

        <section>
            <form action="tasks?action=new_goal" id="newGoal" name="newGoal" method="post" hidden="true">
                <p><input type="text" maxlength="50" name="goal_title" placeholder="Goal Title" class="titleField"
                          autofocus>
                </p>
                <p><textarea maxlength="150" name="goal_description" placeholder="Description"
                             class="descField"></textarea>
                </p>
                <p><input type="submit" value="Add Goal" class="submitButton"></p>
            </form>
        </section>
        <section>
            <form action="tasks?action=new_task" id="newTask" name="newTask" method="post" hidden="true">
                <p><input type="text" maxlength="50" name="title" placeholder="Task Title" class="titleField" autofocus>
                </p>
                <p><textarea maxlength="150" name="description" placeholder="Description" class="descField"></textarea>
                </p>
                <p><input type="submit" value="Add Task" class="submitButton"></p>
            </form>
        </section>

    </div>

<%--    <div class="rightPart">--%>
<%--        <%--%>
<%--            out.print("Task description:");--%>
<%--        %>--%>

<%--    </div>--%>
</div>
<script type="text/javascript">
    var docElementTask = document.getElementById('newTask')
    var docElementGoal = document.getElementById('newGoal')

    function setAddTaskVisible() {
        docElementTask = document.getElementById('newTask')
        docElementGoal = document.getElementById('newGoal')
        if (docElementTask.hidden === true) {
            docElementTask.hidden = false;
            docElementGoal.hidden = true;
        } else {
            docElementTask.hidden = true;
        }
    }

    function setAddGoalVisible() {
        if (docElementGoal.hidden === true) {
            docElementTask.hidden = true;
            docElementGoal.hidden = false;

        } else {
            docElementGoal.hidden = true;
        }
    }

    function showActions() {
        var click = document.getElementById("drop-content");
        if (click.style.display === "none") {
            click.style.display = "block";
        } else {
            click.style.display = "none";
        }
    }

    function showDescription() {

    }
</script>
</body>
</html>