alter system set deferred_segment_creation=false;

drop role jpycompany_role;
create role jpycompany_role;
--to disallow any companies from direct connection, just 
--supress the following grant. otherwise apply it.
grant create session to jpycompany_role;

grant create sequence to jpycompany_role;
grant create table to jpycompany_role;
grant create view to jpycompany_role;
grant create synonym to jpycompany_role;
grant create indextype to jpycompany_role;
grant create operator to jpycompany_role;
grant create procedure to jpycompany_role;
grant create type to jpycompany_role;
grant create trigger to jpycompany_role;
grant create materialized view to jpycompany_role;
grant create job to jpycompany_role;


drop role jpyglobal_role;
create role jpyglobal_role;
grant create session to jpyglobal_role;
grant create user to jpyglobal_role;
--grant drop user to jpyglobal_role;
grant alter user to jpyglobal_role;
grant alter session to jpyglobal_role;

grant jpycompany_role to jpyglobal_role with admin option;

--grant administer any sql tuning set to jpyglobal_role;
--grant administer sql tuning set to jpyglobal_role;

--Grant access to DBA views
grant select any dictionary to jpyglobal_role;
grant select_catalog_role to jpyglobal_role;
grant execute_catalog_role to jpyglobal_role;

--grant advisor to jpyglobal_role;

--grant debug connect session to jpyglobal_role;
--grant debug any procedure to jpyglobal_role;

--
--other grants to make import/exports, and all other day to day functionality work.
--
--grant create any outline to jpyglobal_role;
grant resumable to jpyglobal_role;
grant exp_full_database to jpyglobal_role;
grant imp_full_database to jpyglobal_role;
grant insert any table to jpyglobal_role;
grant update any table to jpyglobal_role;
grant delete any table to jpyglobal_role;
grant select any table to jpyglobal_role;

--
--OBJECT CREATION --
--
grant create any context to jpyglobal_role;
grant drop any context to jpyglobal_role;

grant create any sequence to jpyglobal_role;
grant alter any sequence to jpyglobal_role;
--grant drop any sequence to jpyglobal_role;
grant select any sequence to jpyglobal_role;

grant create table to jpyglobal_role with admin option;

grant create any table to jpyglobal_role;
grant alter any table to jpyglobal_role;
--grant drop any table to jpyglobal_role;
grant backup any table to jpyglobal_role;
grant lock any table to jpyglobal_role;

grant create any index to jpyglobal_role;
grant alter any index to jpyglobal_role;
--grant drop any index to jpyglobal_role;

grant create any view to jpyglobal_role;
--grant drop any view to jpyglobal_role;
grant merge any view to jpyglobal_role;

grant create any synonym to jpyglobal_role;
--grant drop any synonym to jpyglobal_role;

grant create any indextype to jpyglobal_role;
grant alter any indextype to jpyglobal_role;
--grant drop any indextype to jpyglobal_role;

grant create any operator to jpyglobal_role;
grant alter any operator to jpyglobal_role;
--grant drop any operator to jpyglobal_role;

grant create any procedure to jpyglobal_role;
grant alter any procedure to jpyglobal_role;
--grant drop any procedure to jpyglobal_role;

grant create any type to jpyglobal_role;
grant alter any type to jpyglobal_role;
--grant drop any type to jpyglobal_role;

grant create any trigger to jpyglobal_role;
grant alter any trigger to jpyglobal_role;
--grant drop any trigger to jpyglobal_role;

grant create any materialized view to jpyglobal_role;
grant alter any materialized view to jpyglobal_role;
grant drop any materialized view to jpyglobal_role;

--grants to job scheduler
grant create any job to jpyglobal_role;

grant execute any type to jpyglobal_role;
grant execute any indextype to jpyglobal_role;
grant execute any operator to jpyglobal_role;
grant execute any procedure to jpyglobal_role;

create user jpy_main identified by jpy_main;
grant jpycompany_role to jpy_main;



CREATE SMALLFILE TABLESPACE "MVIEW_01" LOGGING DATAFILE 
'C:\ORACLE\ORADATA\DBPOOL1\DBPOOL1_MVIEW_01.DBF' 
SIZE 1000M
EXTENT MANAGEMENT LOCAL SEGMENT SPACE MANAGEMENT MANUAL;

CREATE SMALLFILE TABLESPACE "LOB_01" LOGGING DATAFILE 
'C:\ORACLE\ORADATA\DBPOOL1\DBPOOL1_LOB_01.DBF' 
SIZE 4000M
EXTENT MANAGEMENT LOCAL SEGMENT SPACE MANAGEMENT MANUAL;

CREATE SMALLFILE TABLESPACE "DATA_01" LOGGING DATAFILE 
'C:\ORACLE\ORADATA\DBPOOL1\DBPOOL1_DATA_01.DBF' 
SIZE 3000M
EXTENT MANAGEMENT LOCAL SEGMENT SPACE MANAGEMENT MANUAL;

CREATE SMALLFILE TABLESPACE "INDEX_01" LOGGING DATAFILE 
'C:\ORACLE\ORADATA\DBPOOL1\DBPOOL1_INDEX_01.DBF' 
SIZE 500M
EXTENT MANAGEMENT LOCAL SEGMENT SPACE MANAGEMENT MANUAL;