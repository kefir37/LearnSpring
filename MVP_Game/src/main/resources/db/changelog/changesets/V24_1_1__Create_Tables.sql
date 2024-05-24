create table if not exists t_users(
    id UUID primary key,
    c_username varchar(30) not null unique,
    c_password varchar(50) not null
);