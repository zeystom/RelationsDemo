CREATE SCHEMA IF EXISTS user_schema;

CREATE TABLE IF NOT EXISTS t_users(
    id SERIAL PRIMARY KEY NOT NULL,
    c_name VARCHAR(50) NOT NULL,
    c_age INTEGER CHECK (c_age > 0 AND c_age < 150),
    c_passport_id INTEGER UNIQUE,
    FOREIGN KEY (c_passport_id) REFERENCES t_passports(id)
);

CREATE TABLE IF NOT EXISTS t_passports(
    id SERIAL PRIMARY KEY NOT NULL,
    c_number VARCHAR(12) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS t_accounts(
    id SERIAL PRIMARY KEY NOT NULL,
    c_title VARCHAR(50) NOT NULL,
    c_user_id  INTEGER,
    FOREIGN KEY (c_user_id) REFERENCES t_users(id)
);

CREATE TABLE IF NOT EXISTS t_hobbies(
    id SERIAL PRIMARY KEY NOT NULL,
    c_type VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS t_users_hobbies(
    c_user_id SERIAL,
    c_hobby_id SERIAL,
    PRIMARY KEY (c_user_id, c_hobby_id),
    FOREIGN KEY (c_user_id) REFERENCES  t_users(id),
    FOREIGN KEY(c_hobby_id) REFERENCES t_hobbies(id)

);