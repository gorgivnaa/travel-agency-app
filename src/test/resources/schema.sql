CREATE TABLE users(
    id BIGINT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(200) NOT NULL,
    last_name VARCHAR(200) NOT NULL,
    patronymic VARCHAR(200) NOT NULL,
    email VARCHAR(200) NOT NULL UNIQUE,
    phone_number VARCHAR(200) NOT NULL,
    password VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);