# noinspection SqlNoDataSourceInspectionForFile

CREATE DATABASE IF NOT EXISTS taskmanager CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS taskmanager.user_data (
                                                     user_id int (11) NOT NULL AUTO_INCREMENT,
                                                     user_nickname varchar (30) NOT NULL,
                                                     user_email varchar (70) NOT NULL,
                                                     user_password varchar (30) NOT NULL,
                                                     PRIMARY KEY user_id_PK (user_id),
                                                     UNIQUE KEY email_UK (user_email)
);

CREATE TABLE IF NOT EXISTS taskmanager.task (
                                                task_id int (11) NOT NULL AUTO_INCREMENT,
                                                task_title varchar (50) NOT NULL,
                                                task_description varchar (100),
                                                task_status int (1),
                                                goal_id int (11),
                                                user_id int (11) NOT NULL,
                                                PRIMARY KEY task_id_PK (task_id)
);


CREATE TABLE IF NOT EXISTS taskmanager.goal (
                                                goal_id int (11) NOT NULL AUTO_INCREMENT,
                                                goal_title varchar (50) NOT NULL,
                                                goal_description varchar (100),
                                                goal_status int (1),
                                                parent_goal_id int (11) NULL,
                                                user_id int (11) NOT NULL,
                                                PRIMARY KEY goal_id_PK (goal_id),
                                                FOREIGN KEY subgoal_id_PK (parent_goal_id) REFERENCES taskmanager.goal(goal_id),
                                                FOREIGN KEY goal_user_id_FK (user_id) REFERENCES taskmanager.user_data(user_id)
);

-- select goals with subgoals
SELECT goal.goal_id 'goal id', goal.goal_title 'goal title', goal.goal_description 'goal description',
       goal.goal_status 'goal status', subgoal.parent_goal_id 'subgoal id', subgoal.goal_title 'subgoal title',
       subgoal.goal_description 'subgoal description', subgoal.goal_status  'subgoal status',
       task.task_id 'task id', task.task_title 'task title', task.task_description 'task description',
       task.task_status 'task status', task.goal_id 'task goal id'
FROM taskmanager.goal goal
         LEFT JOIN taskmanager.goal subgoal
                   ON  subgoal.parent_goal_id = goal.goal_id
         LEFT JOIN taskmanager.task task
                   ON goal.goal_id = task.goal_id
UNION
SELECT null, null, null, null, null, null, null, null,
       task_id, task_title, task_description, task_status, goal_id
FROM taskmanager.task
WHERE goal_id IS NULL
ORDER BY 'goal status', 'task status';


SELECT * FROM taskmanager.user_data;
desc taskmanager.user_data;
drop database taskmanager;
drop table taskmanager.user_data;
show databases;