CREATE TABLE users
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    username   VARCHAR(250) NOT NULL,
    password   VARCHAR(250) NOT NULL,
    role       VARCHAR(1) DEFAULT NULL
);