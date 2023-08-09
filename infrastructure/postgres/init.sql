CREATE DATABASE todo;
\connect todo;

create table if not exists task
(
    id          int     not null,
    name        varchar not null,
    description varchar not null,
    status      varchar not null,
    PRIMARY KEY (id)
);

CREATE SEQUENCE todo_seq
    INCREMENT 1
    START 2;

INSERT into task(id, name, description, status) values (1, 'DUMMY', 'description', 'OPEN');