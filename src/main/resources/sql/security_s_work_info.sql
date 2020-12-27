create table s_work_info
(
    work_id          varchar(100) not null,
    work_detail      varchar(255) null,
    create_date      datetime     not null,
    last_update_date datetime     null,
    constraint s_work_info_work_id_uindex
        unique (work_id)
);

alter table s_work_info
    add primary key (work_id);

INSERT INTO security.s_work_info (work_id, work_detail, create_date, last_update_date) VALUES ('1', 'bbaab', '2020-12-27 08:50:27', '2020-12-27 12:21:25');
INSERT INTO security.s_work_info (work_id, work_detail, create_date, last_update_date) VALUES ('2', 'aaa', '2020-12-27 11:40:13', null);
INSERT INTO security.s_work_info (work_id, work_detail, create_date, last_update_date) VALUES ('3', 'aaa', '2020-12-27 11:42:02', null);
INSERT INTO security.s_work_info (work_id, work_detail, create_date, last_update_date) VALUES ('5', 'aaa', '2020-12-27 12:20:26', null);
INSERT INTO security.s_work_info (work_id, work_detail, create_date, last_update_date) VALUES ('6', 'aaa', '2020-12-27 12:21:20', null);