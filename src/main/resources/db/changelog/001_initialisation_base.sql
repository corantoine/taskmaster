--CREATE DATABASE taskmaster;

CREATE TABLE users(
    id SERIAL PRIMARY KEY,
    username VARCHAR(42) NOT NULL UNIQUE,
    firstname VARCHAR(42),
    lastname VARCHAR(42),
    country VARCHAR(42),
    email VARCHAR(100),
    password VARCHAR(42) --TODO remettre les valeurs à NOT NULL + tard en vidant la BDD
);

CREATE TABLE tasks (
    id SERIAL PRIMARY KEY,
    user_id INT REFERENCES users(id),
    task_name VARCHAR(250) NOT NULL,
    --FIXME gérer la date
    due_date TIMESTAMP,
    completion_state BOOLEAN DEFAULT FALSE
);