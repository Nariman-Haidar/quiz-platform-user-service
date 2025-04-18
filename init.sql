USE user_db;

CREATE TABLE roles (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(50) UNIQUE NOT NULL,
                       version BIGINT
);

CREATE TABLE persons (
                         id BIGINT AUTO_INCREMENT PRIMARY KEY,
                         first_name VARCHAR(50) NOT NULL,
                         last_name VARCHAR(50) NOT NULL,
                         username VARCHAR(50) UNIQUE NOT NULL,
                         email VARCHAR(100) UNIQUE NOT NULL,
                         password VARCHAR(255) NOT NULL,
                         phone_number VARCHAR(15),
                         account_locked BOOLEAN NOT NULL DEFAULT FALSE,
                         role_id BIGINT NOT NULL,
                         version BIGINT,
                         FOREIGN KEY (role_id) REFERENCES roles(id)
);

CREATE TABLE password_reset_tokens (
                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       token VARCHAR(255) NOT NULL,
                                       person_id BIGINT NOT NULL,
                                       expiry_date DATETIME NOT NULL,
                                       FOREIGN KEY (person_id) REFERENCES persons(id)
);