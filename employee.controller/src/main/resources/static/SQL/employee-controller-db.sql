CREATE DATABASE employee_controller;

USE employee_controller;

CREATE TABLE Employees (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50),
	email VARCHAR(50) NOT NULL
)ENGINE=InnoDB;

CREATE TABLE Admins (
	user_id VARCHAR(20) NOT NULL PRIMARY KEY,
	password CHAR(68),
	active TINYINT(4)
)ENGINE=InnoDB;

CREATE TABLE Roles (
	user_id VARCHAR(20) NOT NULL,
	`role` VARCHAR(40) NOT NULL,
	UNIQUE KEY `admin_pairs` (`user_id`, `role`),
	CONSTRAINT `admin_roles` FOREIGN KEY (user_id) REFERENCES Admins (user_id)
)ENGINE=InnoDB;

-- dev queries
SELECT * FROM Admins;
SELECT * FROM Roles;

SHOW TABLES;

DESC Employees;

-- admins and roles

-- sample queries
INSERT INTO Admins(user_id, password, active) VALUES ('', '', 1);
INSERT INTO Roles(user_id, role) VALUES ('', ''); 

-- default password is: 'test123' encrypted by Bcrypt
INSERT INTO Admins(user_id, password, active) VALUES ('tom', '{bcrypt}$2a$12$O9/7PUg84E7/e0r32Ieyru4qUZ7Fm62cb2QHP.3j7H51jAqGpmZj6', 1);
INSERT INTO Admins(user_id, password, active) VALUES ('greg', '{bcrypt}$2a$12$O9/7PUg84E7/e0r32Ieyru4qUZ7Fm62cb2QHP.3j7H51jAqGpmZj6', 1);
INSERT INTO Admins(user_id, password, active) VALUES ('lulu', '{bcrypt}$2a$12$O9/7PUg84E7/e0r32Ieyru4qUZ7Fm62cb2QHP.3j7H51jAqGpmZj6', 1);

INSERT INTO Roles(user_id, role) VALUES ('tom', 'ROLE_EMPLOYEE');

INSERT INTO Roles(user_id, role) VALUES ('greg', 'ROLE_EMPLOYEE');
INSERT INTO Roles(user_id, role) VALUES ('greg', 'ROLE_MANAGER');

INSERT INTO Roles(user_id, role) VALUES ('lulu', 'ROLE_EMPLOYEE');
INSERT INTO Roles(user_id, role) VALUES ('lulu', 'ROLE_MANAGER');
INSERT INTO Roles(user_id, role) VALUES ('lulu', 'ROLE_ADMIN');

SELECT * FROM  Admins;
SELECT * FROM Roles;
