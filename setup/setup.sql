CREATE SCHEMA dbcl;

USE DBCL;

CREATE TABLE users (username VARCHAR(50) NOT NULL, password VARCHAR(100) NOT NULL,
    enabled TINYINT NOT NULL DEFAULT 1,  PRIMARY KEY (username));

CREATE TABLE authorities (username VARCHAR(50) NOT NULL, authority VARCHAR(50) NOT NULL,
    FOREIGN KEY (`username`) REFERENCES users(username));

CREATE UNIQUE INDEX ix_auth_username ON authorities(username,authority);

INSERT INTO users (username, password, enabled)
    VALUES ('PDRAGON', '$2a$10$BFomDlVmR5O6dS.uwavxNeDYW9vIg6NqNbMYwJB5vGwGFFtMlYhV2', 1);

INSERT INTO authorities (username, authority) VALUES ('PDRAGON', 'ROLE_ADMIN');

CREATE TABLE chair (chair_id bigint not null, chair_description varchar(255) not null, created datetime not null,
    created_by varchar(45) not null, modified datetime not null, modified_by varchar(45) not null,
    primary key (chair_id));

CREATE TABLE event (evt_id bigint not null, created datetime not null, created_by varchar(45) not null,
    ent_website varchar(255), event_location varchar(255), evt_description longtext not null,
    modified datetime not null, modified_by varchar(45) not null, primary key (evt_id));

CREATE TABLE event_member (event_evt_id bigint not null, member_mbr_id bigint not null);

CREATE TABLE hibernate_sequence (next_val bigint);

INSERT INTO hibernate_sequence values ( 1 );

CREATE TABLE member (id bigint not null, active bit not null, addr1 varchar(45) not null, addr2 varchar(45),
    city varchar(45) not null, created datetime not null, created_by varchar(45) not null, email varchar(80),
    fname varchar(45) not null, lname varchar(45) not null, since varchar(6), mobile varchar(10),
    modified datetime not null, modified_by varchar(45) not null, phone varchar(10), extension varchar(15),
    state varchar(2) not null, user_name varchar(255), zip varchar(11) not null, primary key (id));

CREATE TABLE member_chair (member_id bigint not null, chair_chair_id bigint not null);

CREATE TABLE member_event (member_id bigint not null, event_evt_id bigint not null);

CREATE TABLE practice_range (range_id bigint not null, created datetime not null, created_by varchar(45) not null,
    modified datetime not null, modified_by varchar(45) not null, range_description varchar(255) not null,
    range_open bit, event_evt_id bigint, primary key (range_id));

ALTER TABLE event_member add constraint FK18wqy4dogk9jf0x7b18s9shp8 foreign key (member_mbr_id) references member (id);

ALTER TABLE event_member add constraint FK1vv540wle7h3a3yr3y9xjbkfu foreign key (event_evt_id) references event (evt_id);

ALTER TABLE member_chair add constraint FK9s4h3xjpexvfbfu1b5kvdav9v foreign key (chair_chair_id) references chair (chair_id);

ALTER TABLE member_chair add constraint FK5o5ju8mn3y3ra41kfvlmi2rha foreign key (member_id) references member (id);

ALTER TABLE member_event add constraint FKfalc3xs0v3s4l7mah4lyg2m7d foreign key (event_evt_id) references event (evt_id);

ALTER TABLE member_event add constraint FKelkrq0cqnuvqxsdj7x1fm6jhf foreign key (member_id) references member (id);

ALTER TABLE practice_range add constraint FK41nujyxxuiyolljqg000b1n38 foreign key (event_evt_id) references event (evt_id);

COMMIT;