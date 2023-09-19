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
	user_id VARCHAR(20) NOT NULL PRIMARY KEY,
	`role` VARCHAR(40) NOT NULL,
	CONSTRAINT `admin_roles` FOREIGN KEY (user_id) REFERENCES Admins (user_id)
)ENGINE=InnoDB;

-- dev queries
INSERT INTO Admins(user_id, password, active) VALUES ('test', 'test123', 1);
INSERT INTO Roles(user_id, role) VALUES ('test', 'MANAGER'); 

SELECT * FROM Admins;
SELECT * FROM Roles;