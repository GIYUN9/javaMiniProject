/* 관리자 계정으로 계정생성 및 권한 부여
    CREATE USER MINI IDENTIFIED BY MINI;
    GRANT CONNECT, RESOURCE TO MINI;
*/

-- MINI 유저 생성 및 접속

-- 테이블
DROP TABLE PRODUCT;
CREATE TABLE PRODUCT(
    PRO_NO NUMBER PRIMARY KEY,
    PRO_NAME VARCHAR2(30) UNIQUE,
    PRO_PRICE NUMBER NOT NULL,
    PRO_AMOUNT NUMBER,
    PRO_DESCRIPTION VARCHAR2(100)
);

DROP TABLE CUSTOMER;
CREATE TABLE CUSTOMER(
    CUS_NO NUMBER PRIMARY KEY,
    CUS_ID VARCHAR2(20) UNIQUE,
    CUS_PWD VARCHAR2(20) NOT NULL,
    NICKNAME VARCHAR2(20) DEFAULT 'Unknown',
    ENROLLDATE DATE DEFAULT SYSDATE
);

DROP TABLE BUY;
CREATE TABLE BUY(
    CUS_NO NUMBER REFERENCES CUSTOMER(CUS_NO),
    PRO_NO NUMBER REFERENCES PRODUCT(PRO_NO),
    BUY_DATE DATE DEFAULT SYSDATE
);

-- 시퀀스
CREATE SEQUENCE SEQ_PRO_NO
START WITH 100
INCREMENT BY 1
MAXVALUE 999
NOCYCLE
NOCACHE;

CREATE SEQUENCE SEQ_CUS_NO
START WITH 1000
INCREMENT BY 1
MAXVALUE 1999
NOCYCLE
NOCACHE;

--기본데이터 (test용)
INSERT INTO PRODUCT VALUES (SEQ_PRO_NO.NEXTVAL, '커피', 1500, 2, '시원한 아이스 아메리카노입니다.');

INSERT INTO CUSTOMER VALUES (SEQ_CUS_NO.NEXTVAL, 'TEST_ID01', 'TEST_PWD_01', 'nickTEST', SYSDATE);

INSERT INTO BUY VALUES (1000, 100, SYSDATE);

-- SELECT문으로 간단 확인
--SELECT NICKNAME, B.CUS_NO, PRO_NAME, SYSDATE
--FROM BUY B
--JOIN customer C ON B.CUS_NO = C.CUS_NO
--JOIN product P ON B.PRO_NO = P.PRO_NO;
