Create database airline_db;

CREATE TABLE tickets (
    ticket_id INT AUTO_INCREMENT PRIMARY KEY,
    airline_name VARCHAR(100) NOT NULL,
    departure VARCHAR(100) NOT NULL,
    destination VARCHAR(100) NOT NULL,
    journey_date DATE NOT NULL,
    passenger_name VARCHAR(150) NOT NULL,
    age INT NOT NULL,
    gender ENUM('Male', 'Female', 'Other') NOT NULL,
    email_id VARCHAR(150) NOT NULL,
    mobile_no CHAR(10) NOT NULL UNIQUE,
    aadhar_no CHAR(12) NOT NULL UNIQUE
);
SELECT * FROM tickets;