DROP DATABASE IF EXISTS FinalExam;
CREATE DATABASE IF NOT EXISTS FinalExam;
USE FinalExam;

DROP TABLE IF EXISTS `User`; 
CREATE TABLE `User`(
	UserID 		TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	FullName 	VARCHAR(50) UNIQUE KEY NOT NULL,
    Email 		VARCHAR(50) UNIQUE KEY NOT NULL,
    `Password`	VARCHAR(50) NOT NULL CHECK(length(`Password`) >= 6 and length(`Password`) <= 12),
    `Position`	ENUM('Manager', 'Employee'),
    ExpInYear	TINYINT UNSIGNED,
    ProSkill	NVARCHAR(50)
);

DROP TABLE IF EXISTS Project;
CREATE TABLE  `Project`(
	ProjectID	TINYINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	IdManager	TINYINT UNSIGNED,
	FOREIGN KEY (IdManager) 	REFERENCES `User`(UserID)
);

DROP TABLE IF EXISTS EmployeeProject;
CREATE TABLE EmployeeProject(
    IdEmployee	TINYINT UNSIGNED,
    ProjectID	TINYINT UNSIGNED,
    FOREIGN KEY (IdEmployee) 	REFERENCES `User`(UserID),
    FOREIGN KEY (ProjectID)		REFERENCES `Project`(ProjectID)
);

INSERT INTO `User`  (UserID   , FullName, 			Email,				 `Password`,			`Position`		) 
VALUES
					(1,			N'Nguyễn A','nguyen.vana@gmail.com','nguyenvana','Employee'	),
					(2,			N'Nguyễn B','nguyen.vanb@gmail.com','nguyenvanb','Manager'	),
                    (3,			N'Nguyễn C','nguyen.vanc@gmail.com', 'Gumball1','Employee'	),
                    (4,			N'Nguyễn D','nguyen.vand@gmail.com', '123456789','Employee'	),
                    (5,			N'Nguyễn E','nguyen.vane@gmail.com', 'nguyenvan22','Employee');
 
 INSERT INTO  `Project`(ProjectID,IdManager)
 VALUES		
						(1,	2),
                        (2, 2),
                        (3, 2);
                        
INSERT INTO EmployeeProject (ProjectID, IdEmployee)
VALUES	
						(1, 3),
                        (1, 4),
                        (1, 5),
                        (2, 3),
                        (3, 4);