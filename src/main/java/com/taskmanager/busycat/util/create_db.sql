CREATE DATABASE IF NOT EXISTS taskmanager CHARACTER SET utf8 COLLATE utf8_general_ci;
CREATE TABLE IF NOT EXISTS taskmanager.user_data (
user_id int (11) NOT NULL AUTO_INCREMENT,
user_login varchar (30) NOT NULL, 
user_password varchar (30) NOT NULL, 
user_email varchar (70) NOT NULL,
PRIMARY KEY user_id_PK (user_id), 
UNIQUE KEY login_UK (user_login), 
UNIQUE KEY password_UK (user_password),
UNIQUE KEY email_UK (user_email)
); 


SELECT * FROM taskmanager.user_data;

-- desc taskmanager.user_data;
-- drop database taskmanager;
-- drop table taskmanager.user_data;
-- show databases;