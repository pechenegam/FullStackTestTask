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

CREATE TABLE conversion
(
    id  bigserial not null,
    created_date timestamp,
    updated_date timestamp,
    ecb_date date,
    from_value float8,
    to_value float8,
    conversion_from_id int8,
    conversion_to_id int8,
    author_id int8,
    primary key (id)
);

CREATE TABLE exchange_rate
(
    id  bigserial not null,
    created_date timestamp,
    updated_date timestamp,
    currency varchar(255),
    ecb_date date,
    rate float8,
    primary key (id)
);

create table refreshtoken
(
    id int8 not null,
    expiry_date timestamp not null,
    token varchar(255) not null,
    user_id int8,
    primary key (id)
)

