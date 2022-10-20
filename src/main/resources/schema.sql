DROP TABLE IF EXISTS notice;

CREATE TABLE notice(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(30),
    content VARCHAR(100),
    who VARCHAR(30),
    createDate TIMESTAMP NOT NULL,
    updateDate TIMESTAMP NOT NULL
);

CREATE TABLE member(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    email VARCHAR(30),
    password VARCHAR(500),
    createDate TIMESTAMP NOT NULL,
    updateDate TIMESTAMP NOT NULL
);

CREATE TABLE lecture(
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    maxPerson INTEGER,
    nowPerson INTEGER,
    who VARCHAR(30),
    createDate TIMESTAMP NOT NULL,
    updateDate TIMESTAMP NOT NULL
);

create table application(
    id BIGINT NOT NULL AUTO_INCREMENT,
    lectureId BIGINT NOT NULL,
    status VARCHAR(30) NOT NULL,
    who VARCHAR(30),
    createDate TIMESTAMP NOT NULL,
    updateDate TIMESTAMP NOT NULL
);
