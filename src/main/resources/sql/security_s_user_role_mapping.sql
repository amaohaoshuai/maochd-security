create table s_user_role_mapping
(
    user_id varchar(100) not null,
    role_id varchar(100) not null
);

INSERT INTO security.s_user_role_mapping (user_id, role_id) VALUES ('1', '2');
INSERT INTO security.s_user_role_mapping (user_id, role_id) VALUES ('2', '1');