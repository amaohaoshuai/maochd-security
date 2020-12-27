create table s_role
(
    role_id   varchar(100) not null,
    role_name varchar(50)  not null,
    constraint s_role_role_id_uindex
        unique (role_id)
);

alter table s_role
    add primary key (role_id);

INSERT INTO security.s_role (role_id, role_name) VALUES ('1', 'admin');
INSERT INTO security.s_role (role_id, role_name) VALUES ('2', 'normal');