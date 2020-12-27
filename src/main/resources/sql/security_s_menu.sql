create table s_menu
(
    menu_id         varchar(100) not null,
    menu_name       varchar(50)  not null,
    menu_permission varchar(100) not null,
    constraint s_menu_menu_id_uindex
        unique (menu_id)
);

alter table s_menu
    add primary key (menu_id);

INSERT INTO security.s_menu (menu_id, menu_name, menu_permission) VALUES ('1', 'system_management', '/systemManagement/addUser');
INSERT INTO security.s_menu (menu_id, menu_name, menu_permission) VALUES ('2', 'system_management', '/systemManagement/deleteUser');
INSERT INTO security.s_menu (menu_id, menu_name, menu_permission) VALUES ('3', 'work_detail', '/workDetail/addWork');
INSERT INTO security.s_menu (menu_id, menu_name, menu_permission) VALUES ('4', 'work_detail', '/workDetail/modifyWork');