CREATE TABLE users
(
    userID int PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) UNIQUE,
    password VARCHAR(100),
    email VARCHAR(100) UNIQUE,
)