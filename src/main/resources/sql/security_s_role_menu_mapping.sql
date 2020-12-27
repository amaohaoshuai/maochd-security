create table s_role_menu_mapping
(
    role_id varchar(100) not null,
    menu_id varchar(100) not null
);

INSERT INTO security.s_role_menu_mapping (role_id, menu_id) VALUES ('1', '1');
INSERT INTO security.s_role_menu_mapping (role_id, menu_id) VALUES ('1', '2');
INSERT INTO security.s_role_menu_mapping (role_id, menu_id) VALUES ('1', '3');
INSERT INTO security.s_role_menu_mapping (role_id, menu_id) VALUES ('1', '4');
INSERT INTO security.s_role_menu_mapping (role_id, menu_id) VALUES ('2', '3');
INSERT INTO security.s_role_menu_mapping (role_id, menu_id) VALUES ('2', '4');