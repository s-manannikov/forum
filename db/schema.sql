create table authorities (
    id serial primary key,
    authority varchar(50) not null unique
);

create table users (
    id serial primary key,
    username varchar(100) not null unique,
    email varchar(100) not null,
    password varchar(100) not null,
    enabled boolean default true,
    authority_id int not null references authorities(id)
);

create table posts (
    id serial primary key,
    name varchar(200) not null,
    description text not null,
    created timestamp without time zone not null default now(),
    user_id int references users(id)
);

create table replies (
    id serial primary key,
    description text not null,
    created timestamp without time zone not null default now(),
    post_id int references posts(id),
    user_id int references users(id)
);

insert into authorities (authority) values ('ROLE_USER');
insert into authorities (authority) values ('ROLE_ADMIN');

insert into users (username, email, password, enabled, authority_id)
values ('admin', '@', '$2a$10$g8wVg2fH0Qiks6x9ePIxUe490LHEVRqvcmrU2miZvoeWrFoRYuqAi', true,
        (select id from authorities where authority = 'ROLE_ADMIN'));