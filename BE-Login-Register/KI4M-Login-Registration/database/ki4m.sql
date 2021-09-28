DROP DATABASE IF EXISTS ideal;
CREATE DATABASE ideal;
USE ideal;

DROP TABLE IF EXISTS `Account`;
CREATE TABLE IF NOT EXISTS `Account` ( 	
	id 				SMALLINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	username	 	CHAR(50) NOT NULL UNIQUE KEY CHECK (LENGTH(`username`) >= 6 AND LENGTH(`username`) <= 50),
	email			CHAR(50) NOT NULL UNIQUE CHECK (LENGTH(`email`) >= 6 AND LENGTH(`email`) <= 50),
	`password` 		VARCHAR(800) NOT NULL,
    fullName		NVARCHAR(50) NOT NULL,
    `role`			ENUM('Admin','User') NOT NULL DEFAULT 'User',
    `status`		TINYINT DEFAULT 0, -- 0: Not Active, 1: Active
    createDate		DATETIME DEFAULT NOW()

);
-- Create table Registration_User_Token
DROP TABLE IF EXISTS 	`Registration_User_Token`;
CREATE TABLE IF NOT EXISTS `Registration_User_Token` ( 	
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	`account_id` 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL
);
-- Create table Reset_Password_Token
DROP TABLE IF EXISTS 	`Reset_Password_Token`;
CREATE TABLE IF NOT EXISTS `Reset_Password_Token` ( 	
	id 				INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	`token`	 		CHAR(36) NOT NULL UNIQUE,
	`account_id` 		SMALLINT UNSIGNED NOT NULL,
	`expiryDate` 	DATETIME NOT NULL
);
-- Create table Target
DROP TABLE IF EXISTS target;
CREATE TABLE target( 
	
	ID						TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    target					VARCHAR(100) NOT NULL UNIQUE KEY,
    completion_rate			VARCHAR(100) NOT NULL UNIQUE KEY,
    target_date_completed	VARCHAR(50) NOT NULL UNIQUE KEY,
    CreateDate				DATETIME DEFAULT NOW()
);
-- Create table small_leg
DROP TABLE IF EXISTS small_leg;
CREATE TABLE small_leg( 
	ID						TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    small_leg				VARCHAR(100) NOT NULL UNIQUE KEY,
    start_day				DATETIME DEFAULT NOW(),
    finish_day				DATETIME NOT NULL
);
-- Add data Account


                   

                    

