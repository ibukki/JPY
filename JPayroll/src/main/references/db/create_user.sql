--------------------------------------------------------
--  DDL for Table USER_LOGIN
--------------------------------------------------------

  CREATE TABLE "JPY"."USER_LOGIN" 
   (	"USERID" NUMBER(10,0), 
	"USERNAME" VARCHAR2(50 BYTE), 
	"EMAIL" VARCHAR2(100 BYTE), 
	"MOBILE" VARCHAR2(20 BYTE), 
	"PASSWORD" VARCHAR2(100 BYTE), 
	"LASTACCESSED" DATE, 
	"FAILEDCOUNT" NUMBER(*,0), 
	"EXPIREDATE" DATE, 
	"STATUS" CHAR(1 BYTE)
   ) 
  TABLESPACE "LOB_01" ;
  
  
--------------------------------------------------------
--  DDL for Table USER_INFO
--------------------------------------------------------

  CREATE TABLE "JPY"."USER_INFO" 
   (	"USERID" NUMBER(10,0), 
	"USERNAME" VARCHAR2(100 BYTE), 
	"FIRSTNAME" VARCHAR2(50 BYTE), 
	"LASTNAME" VARCHAR2(50 BYTE), 
	"GENDER" CHAR(1 BYTE), 
	"DATEOFBIRTH" DATE, 
	"DEPARTMENT" VARCHAR2(50 BYTE), 
	"POSITION" VARCHAR2(50 BYTE), 
	"SCHEMAID" VARCHAR2(50 BYTE), 
	"EEGROUPID" VARCHAR2(50 BYTE)
   ) 
  TABLESPACE "LOB_01" ;

--------------------------------------------------------
--  DDL for Sequence USER_ID_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "JPY"."USER_ID_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
