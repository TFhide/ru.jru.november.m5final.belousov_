--liquibase formatted sql

--changeset vbelousov:insert_data_in_table_activity

insert into ACTIVITY ( ID, AUTHOR_ID, TASK_ID, UPDATED, STATUS_CODE )
    values (7, 13, 93, '2023-08-28 18:41:59.211469', 'in_progress' ),
           (8, 13, 93, '2023-08-28 19:20:59.901469', 'ready_for_review' ),
           (9, 13, 93, '2023-08-28 20:30:02.801469', 'done' );
