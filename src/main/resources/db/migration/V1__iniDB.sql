create table usr
(
    id BIGSERIAL primary key,
    created_date timestamp,
    updated_date timestamp,
    username     varchar(255),
    password     varchar(255)
);

create table role
(
    id BIGSERIAL primary key,
    name varchar(255)
);

CREATE TABLE usr_role
(
    user_id BIGSERIAL NOT NULL REFERENCES usr (id),
    role_id BIGSERIAL NOT NULL REFERENCES role (id),
    PRIMARY KEY (user_id, role_id)
);

--CREATE TABLE conversion
--(
--    id  bigserial not null,
--    created_date timestamp,
--    updated_date timestamp,
--    ecb_date date,
--    from_value float8,
--    to_value float8,
--    conversion_from_id int8,
--    conversion_to_id int8,
--    author_id int8,
--    primary key (id)
--);
--
--CREATE TABLE exchange_rate
--(
--    id  bigserial not null,
--    created_date timestamp,
--    updated_date timestamp,
--    currency varchar(255),
--    ecb_date date,
--    rate float8,
--    primary key (id)
--);
--
--create table refreshtoken
--(
--    id int8 not null,
--    expiry_date timestamp not null,
--    token varchar(255) not null,
--    user_id int8,
--    primary key (id)
--)

--alter table refreshtoken drop constraint UK_or156wbneyk8noo4jstv55ii3;
--
--alter table refreshtoken add constraint UK_or156wbneyk8noo4jstv55ii3 unique (token);
--
--create sequence hibernate_sequence start 1 increment 1;
--
--alter table conversion add constraint FKmrl6xqcfbteauns00xg7ymc7i
--foreign key (conversion_from_id) references exchange_rate;
--
--alter table conversion add constraint FKjn9weyjv9jy8rtt6f44k77e88
--foreign key (conversion_to_id) references exchange_rate;
--
--alter table conversion add constraint FKoy3pdu0vx9ngjn7toe5uey6nx
--foreign key (author_id) references usr;
--
--alter table refreshtoken add constraint FKbmpfywuedvc9lufbnx3l785br
--foreign key (user_id) references usr