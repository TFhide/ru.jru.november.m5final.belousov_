--liquibase formatted sql

--changeset vbelousov:insert_data_task_tag

-- 0 REST_API
-- 1 TESTS
-- 2 MEETING
-- 3 SPRINT
-- 4 PROJECT

DELETE
FROM TASK_TAG;
insert into TASK_TAG (TASK_ID, TAG)
values (4, '#sprint'),
       (102, '#test'),
       (106, '#test'),
       (110, '#test'),
       (93, '#rest_api'),
       (101, '#rest_api'),
       (105, '#rest_api'),
       (109, '#rest_api'),
       (116, '#rest_api'),
       (121, '#meeting'),
       (9, '#sprint'),
       (87, '#sprint'),
       (96, '#sprint'),
       (97, '#sprint'),
       (124, '#sprint'),
       (5, '#project');
