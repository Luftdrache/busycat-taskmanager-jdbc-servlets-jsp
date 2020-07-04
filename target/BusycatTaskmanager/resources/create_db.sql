# noinspection SqlNoDataSourceInspectionForFile

CREATE DATABASE IF NOT EXISTS taskmanager CHARACTER SET utf8 COLLATE utf8_general_ci;

CREATE TABLE IF NOT EXISTS taskmanager.user_data (
user_id int (11) NOT NULL AUTO_INCREMENT,
user_nickname varchar (30) NOT NULL,
user_password varchar (30) NOT NULL,
user_email varchar (70) NOT NULL,
PRIMARY KEY user_id_PK (user_id),
UNIQUE KEY email_UK (user_email)
);

CREATE TABLE IF NOT EXISTS taskmanager.goal (
goal_id int (11) NOT NULL AUTO_INCREMENT,
goal_title varchar (30) NOT NULL,
goal_description varchar (100),
subgoal_id int (11),
task_id int (11),
user_id int (11) NOT NULL,
PRIMARY KEY goal_id_PK (goal_id),
FOREIGN KEY goal_user_id_FK (user_id) REFERENCES taskmanager.user_data(user_id)
);

CREATE TABLE IF NOT EXISTS taskmanager.task (
task_id int (11) NOT NULL AUTO_INCREMENT,
task_title varchar (30) NOT NULL,
task_description varchar (100),
goal_id int (11),
user_id int (11) NOT NULL,
PRIMARY KEY task_id_PK (task_id),
FOREIGN KEY task_user_id_FK (user_id) REFERENCES taskmanager.user_data(user_id),
FOREIGN KEY task_goal_id_FK (goal_id) REFERENCES taskmanager.goal(goal_id)
);



SELECT * FROM taskmanager.user_data;
desc taskmanager.user_data;
drop database taskmanager;
drop table taskmanager.user_data;
show databases;