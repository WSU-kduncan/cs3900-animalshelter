CREATE DATABASE IF NOT EXISTS shelter;

USE shelter;

-- Pets
-- DROP TABLE IF EXISTS shelter.pet;

--Create Table
CREATE TABLE pet
(
	 pet_ID		INT		NOT NULL	AUTO_INCREMENT	COMMENT 'identifying number for pet' 
	,pet_name	VARCHAR(35)     NOT NULL 			COMMENT 'name of the pet'
	,species        VARCHAR(15)     NOT NULL			COMMENT 'species of the animal'
	,breed          VARCHAR(25)     NOT NULL 			COMMENT 'Breed of the animal'
	,sex		VARCHAR(7)	NOT NULL			COMMENT 'Sex of the animal'
	,weight		DECIMAL(5,2)	NOT NULL			COMMENT 'Weight of the animal'
	,intake_date	DATE 		NOT NULL			COMMENT 'Date pet joined shelter'
	,age            SMALLINT        NOT NULL 			COMMENT 'animals age in terms of years'
	,pet_status     VARCHAR(15)     DEFAULT 'Not Adopted' 		COMMENT 'Animals adoption status' 
	,CONSTRAINT chk_pet_status CHECK (pet_status in ('Not Adopted', 'Adopted')) 
	,PRIMARY KEY (pet_ID) 						COMMENT 'Pet identification number that is the primary key'
)
COMMENT 'Pet'
;
INSERT INTO shelter.pet (pet_name, species, breed, sex, weight, intake_date, age, pet_status)
VALUES
('Stitch', 'dog', 'French Bulldog', 'Male', 5, '1998-05-31', 3, 'adopted'),
('Bella', 'cat', 'Siamese', 'Female', 10, '2023-06-15', 2, 'not adopted'),
('Max', 'dog', 'Labrador Retriever', 'Male', 30, '2024-01-20', 1, 'adopted'),
('Lucy', 'rabbit', 'Himalayan', 'Female', 5, '2024-03-12', 1, 'not adopted'),
('Milo', 'cat', 'Maine Coon', 'Male', 15, '2022-09-05', 4, 'not adopted'),
('Rocky', 'dog', 'Pit Bull', 'Male', 40, '2022-12-15', 3, 'adopted'),
('Coco', 'cat', 'Persian', 'Female', 8, '2023-11-10', 2, 'not adopted'),
('Luna', 'dog', 'German Shepherd', 'Female', 35, '2024-07-22', 2, 'not adopted'),
('Oscar', 'rabbit', 'English Angora', 'Male', 4, '2024-02-05', 1, 'adopted'),
('Sammy', 'bird', 'Parakeet', 'Male', 0.3, '2024-05-10', 1, 'not adopted'),
('Buddy', 'dog', 'Golden Retriever', 'Male', 32, '2024-02-10', 1, 'adopted'),
('Charlie', 'cat', 'Bengal', 'Male', 12, '2023-08-25', 2, 'not adopted'),
('Daisy', 'dog', 'Beagle', 'Female', 15, '2023-11-12', 3, 'adopted'),
('Oliver', 'dog', 'Bulldog', 'Male', 25, '2023-07-18', 2, 'not adopted'),
('Lily', 'cat', 'Ragdoll', 'Female', 10, '2024-01-05', 1, 'adopted'),
('Jack', 'rabbit', 'Himalayan', 'Male', 6, '2024-03-02', 2, 'not adopted'),
('Toby', 'dog', 'Shih Tzu', 'Male', 8, '2023-10-19', 3, 'adopted'),
('Sadie', 'cat', 'British Shorthair', 'Female', 14, '2024-03-15', 2, 'not adopted'),
('Rocky', 'dog', 'Chihuahua', 'Male', 6, '2023-11-21', 1, 'adopted'),
('Zoe', 'dog', 'Boxer', 'Female', 40, '2024-02-14', 1, 'not adopted'),
('Bailey', 'dog', 'Poodle', 'Male', 12, '2023-09-10', 4, 'adopted'),
('Sophie', 'cat', 'Sphynx', 'Female', 8, '2024-03-11', 3, 'not adopted'),
('Cleo', 'rabbit', 'Himalayan', 'Female', 5, '2024-04-01', 2, 'adopted'),
('Henry', 'dog', 'Cocker Spaniel', 'Male', 15, '2023-12-05', 3, 'adopted'),
('Chester', 'bird', 'Cockatoo', 'Male', 1.2, '2024-02-20', 2, 'not adopted');


-- DROP TABLE IF EXISTS shelter.adopter;

CREATE TABLE shelter.adopter(
adopter_ID	INT NOT NULL AUTO_INCREMENT -- adopter ID number
,first_name VARCHAR(35) NOT NULL -- first name of adopter
,last_name VARCHAR(35) NOT NULL -- last name of adopter
,email VARCHAR(128) NOT NULL -- email of adopter
,phone CHAR(10) NOT NULL -- phone number of adopter
,PRIMARY KEY (adopter_ID)
);
INSERT INTO shelter.adopter (first_name, last_name, email, phone) VALUES
('John', 'Doe', 'john.doe@example.com', '1234567890'),
('Jane', 'Smith', 'jane.smith@example.com', '0987654321'),
('Michael', 'Johnson', 'michael.johnson@example.com', '1122334455'),
('Emily', 'Davis', 'emily.davis@example.com', '2233445566'),
('James', 'Wilson', 'james.wilson@example.com', '3344556677'),
('Olivia', 'Brown', 'olivia.brown@example.com', '4455667788'),
('William', 'Jones', 'william.jones@example.com', '5566778899'),
('Sophia', 'Miller', 'sophia.miller@example.com', '6677889900'),
('Benjamin', 'Taylor', 'benjamin.taylor@example.com', '7788990011'),
('Isabella', 'Anderson', 'isabella.anderson@example.com', '8899001122'),
('Lucas', 'Thomas', 'lucas.thomas@example.com', '9900112233'),
('Charlotte', 'Jackson', 'charlotte.jackson@example.com', '1012345678'),
('Henry', 'White', 'henry.white@example.com', '2123456789'),
('Amelia', 'Harris', 'amelia.harris@example.com', '3234567890'),
('Alexander', 'Martin', 'alexander.martin@example.com', '4345678901'),
('Mia', 'Lee', 'mia.lee@example.com', '5456789012'),
('Ethan', 'Perez', 'ethan.perez@example.com', '6567890123'),
('Avery', 'Wright', 'avery.wright@example.com', '7678901234'),
('Jack', 'Lopez', 'jack.lopez@example.com', '8789012345'),
('Harper', 'Gonzalez', 'harper.gonzalez@example.com', '9890123456'),
('Daniel', 'Walker', 'daniel.walker@example.com', '0901234567'),
('Ella', 'Young', 'ella.young@example.com', '2012345678'),
('Samuel', 'King', 'samuel.king@example.com', '3123456789'),
('Lily', 'Scott', 'lily.scott@example.com', '4234567890'),
('David', 'Adams', 'david.adams@example.com', '5345678901'),
('Zoe', 'Baker', 'zoe.baker@example.com', '6456789012');


CREATE TABLE shelter.staff(
	 staff_ID       INT		NOT NULL	AUTO_INCREMENT	COMMENT 'Staff ID Number'
	,first_name     VARCHAR(35)     NOT NULL	 		COMMENT 'Staff First Name'
	,last_name      VARCHAR(35)     NOT NULL	 		COMMENT 'Staff Last Nam'
	,position       VARCHAR(50)     NOT NULL	 		COMMENT 'Staff Position'
	,phone          CHAR(10)        NOT NULL	 		COMMENT 'Staff Phone Number'

	,PRIMARY KEY (staff_ID)						COMMENT 'the ID number of staff is the primary key'
)
COMMENT 'Staff'
;

INSERT INTO shelter.staff (first_name, last_name, position, phone) VALUES
('Alice', 'Green', 'Manager', '1234567890'),
('Bob', 'Brown', 'Assistant Manager', '2345678901'),
('Charlie', 'Smith', 'Veterinarian', '3456789012'),
('Diana', 'Johnson', 'Adoption Coordinator', '4567890123'),
('Edward', 'White', 'Trainer', '5678901234'),
('Fiona', 'Martinez', 'Caretaker', '6789012345'),
('George', 'Davis', 'Volunteer Coordinator', '7890123456'),
('Hannah', 'Miller', 'Shelter Worker', '8901234567'),
('Ian', 'Wilson', 'Facility Maintenance', '9012345678'),
('Jenna', 'Taylor', 'Marketing Specialist', '1123456789'),
('Kyle', 'Anderson', 'Public Relations', '2234567890'),
('Lily', 'Thomas', 'Events Coordinator', '3345678901'),
('Mason', 'Jackson', 'Finance Officer', '4456789012'),
('Nina', 'Lee', 'Social Media Manager', '5567890123'),
('Oscar', 'Harris', 'Fundraising Specialist', '6678901234');



CREATE TABLE shelter.adoption_application
(
	  --
	 application_ID	INT             NOT NULL	AUTO_INCREMENT 	--  'adopter identification number'
	,pet_ID               	INT     	NOT NULL					--  'Pet ID Number'
	,adopter_ID           	INT     	NOT NULL					--  'Adopter ID Number'
	,staff_ID             	INT     	NOT NULL					--  'Staff ID Number'
	,application_date                 	DATE 							--  'Date of Application'
	,application_status               	VARCHAR(15) 	DEFAULT 'Pending' 				--  'Status of Application'
	,CONSTRAINT chk_application_status CHECK (application_status in ('Pending', 'Approved', 'Rejected'))

	,PRIMARY KEY (application_ID)								--  'the ID number of the application is the primary key'
)
--  'Adoption Application'
;

ALTER TABLE shelter.adoption_application
	ADD CONSTRAINT	adoption_application_pet_fk
	FOREIGN KEY	(pet_ID)
	REFERENCES      shelter.pet (pet_ID)
	ON DELETE RESTRICT
	ON UPDATE RESTRICT;

ALTER TABLE shelter.adoption_application
	ADD CONSTRAINT	adoption_application_adopter_fk
	FOREIGN KEY     (adopter_ID)
	REFERENCES      shelter.adopter (adopter_ID)
	ON DELETE RESTRICT
	ON UPDATE RESTRICT;

ALTER TABLE shelter.adoption_application
	ADD CONSTRAINT	adoption_application_staff_fk
	FOREIGN KEY     (staff_ID)
	REFERENCES      shelter.staff (staff_ID)
	ON DELETE RESTRICT
	ON UPDATE RESTRICT;

INSERT INTO shelter.adoption_application (pet_ID, adopter_ID, staff_ID, application_date, application_status)
VALUES
(1, 1, 4, '2024-12-01', 'Pending'),  -- Application for pet with ID 1, adopter with ID 1, staff with ID 4
(2, 3, 5, '2024-12-01', 'Pending'),  -- Application for pet with ID 2, adopter with ID 3, staff with ID 5
(3, 7, 2, '2024-12-01', 'Pending'),  -- Application for pet with ID 3, adopter with ID 7, staff with ID 2
(4, 9, 6, '2024-12-01', 'Pending'),  -- Application for pet with ID 4, adopter with ID 9, staff with ID 6
(5, 10, 3, '2024-12-01', 'Pending'), -- Application for pet with ID 5, adopter with ID 10, staff with ID 3
(6, 11, 4, '2024-12-01', 'Pending'); -- Application for pet with ID 6, adopter with ID 11, staff with ID 4

		
