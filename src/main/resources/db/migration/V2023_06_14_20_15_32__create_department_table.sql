create table `department`
(
    `id`          varchar(32)   not null primary key,
    `name`        varchar(512)  not null,
    `create_time` timestamp     not null,
    `update_time` timestamp     not null,
    `deleted`     tinyint(1) not null default '0'
);

alter table user add column `department_id` varchar(32) not null;