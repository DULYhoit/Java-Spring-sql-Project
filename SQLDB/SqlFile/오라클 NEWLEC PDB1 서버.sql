
CREATE TABLE MEMBER
(
    ID VARCHAR2(50),
    PWD NVARCHAR2(50),
    NAME NVARCHAR2(50),
    GENDER NCHAR(2),
    AGE NUMBER(3),
    BIRTHDAY CHAR(10),
    PHONE CHAR(13),
    REGDATE DATE
);    
INSERT INTO MEMBER VALUES('new11','44122','남길동','남성',31,'1996-03-01','010-333-1111',systimestamp);

CREATE TABLE NOTICE
(
    ID          NUMBER,
    TITLE       NVARCHAR2(100),
    WRITER_ID   NVARCHAR2(50),
    CONTENT     CLOB,
    REGDATE     TIMESTAMP,
    HIT         NUMBER,
    FILES       NVARCHAR2(1000)
);
 INSERT INTO NOTICE(TITLE,WRITER_ID,CONTENT,REGDATE,HIT,FILES) VALUES('test','test','test',systimestamp,41,null);
 SELECT * FROM NOTICE;

CREATE TABLE "COMMENT"
(
    ID          NUMBER,
    CONTENT     NVARCHAR2(2000),
    REGDATE     TIMESTAMP,
    WRITER_ID   NVARCHAR2(50),
    NOTICE_ID   NUMBER
);

CREATE TABLE ROLE
(
    ID          VARCHAR(50),
    DESCRIPTION VARCHAR2(500)
);

CREATE TABLE MEMBER_ROLE
(
    MEMBER_ID   NVARCHAR2(50),
    ROLE_ID     VARCHAR(50)
);

INSERT INTO MEMBER(GENDER) VALUES('남성');

INSERT INTO MEMBER(ID,NAME, PWD) VALUES('test','홍길동','111');

UPDATE MEMBER SET PWD='pwd3939' WHERE ID='kim123';

UPDATE MEMBER SET NAME='홍길동' WHERE ID='gugu99';

DELETE MEMBER WHERE NAME IS NULL;

SELECT ID "USER ID" , NAME 이름, PWD 비밀번호 FROM MEMBER;

SELECT  NAME||'('||ID||')' 이름 FROM MEMBER;

SELECT LENGTHB(GENDER) FROM MEMBER;

ALTER TABLE MEMBER MODIFY ID NVARCHAR2(50);

ALTER TABLE MEMBER DROP COLUMN AGE;

ALTER TABLE MEMBER ADD EMAIL VARCHAR2(200);

INSERT INTO NOTICE(HIT) VALUES(5);

SELECT HIT+1 HIT FROM NOTICE;

SELECT 1||'3' FROM DUAL;

SELECT * fROM NOTICE WHERE TITLE LIKE '%DB%';

SELECT * FROM NOTICE WHERE REGEXP_LIKE(TITLE,'01[016-9]-\d{3,4}-\d{4}');

/*ROWNUM 연습*/
SELECT * FROM MEMBER WHERE ROWNUM BETWEEN 1 AND 5;

SELECT * FROM (SELECT ROWNUM NUM, n.* FROM (SELECT * FROM NOTICE ORDER BY ID)n) WHERE NUM BETWEEN 1 AND 10;

/*문자함수*/
SELECT DISTINCT AGE FROM MEMBER;

SELECT NAME ,SUBSTR(BIRTHDAY,6,2)||'월' MONTH FROM MEMBER;

SELECT * FROM MEMBER WHERE PHONE IS NOT NULL AND SUBSTR(BIRTHDAY,6,2) IN ('03','04','05');

SELECT LOWER('NeWLEC') FROM DUAL;
SELECT UPPER('NeWLEC') FROM DUAL;
SELECT * FROM MEMBER WHERE LOWER(ID) = 'new7';

SELECT REPLACE('WHERE WE ARE','WE','YOU') FROM DUAL;
SELECT TRANSLATE('WHERE WE ARE','WE','YOU') FROM DUAL;
SELECT WRITER_ID ||' '|| REPLACE(TITLE,' ','') FROM NOTICE;

SELECT RPAD(NAME, 6,'0') FROM MEMBER;

SELECT INITCAP('the important thing is....') FROM DUAL;

SELECT INSTR('ALL WE NEED TO IS JUST TO ...','TO',1,2) - INSTR('ALL WE NEED TO IS JUST TO ...','TO',1,1) FROM DUAL; 
SELECT SUBSTR(PHONE, 5, INSTR(PHONE,'-' , 1, 2) -INSTR(PHONE,'-' , 1, 1)-1) FROM MEMBER;

SELECT ROUND(3.41234),ROUND(3.51234) FROM DUAL;

/*날짜함수*/
SELECT SYSDATE,CURRENT_DATE,SYSTIMESTAMP,CURRENT_TIMESTAMP FROM DUAL;
SELECT * FROM MEMBER WHERE EXTRACT(MONTH FROM REGDATE) IN(2,3);
SELECT * FROM MEMBER WHERE ADD_MONTHS(SYSDATE,-6) >= REGDATE;
SELECT MONTHS_BETWEEN(SYSDATE,TO_DATE('2013-06-05')) FROM DUAL;
SELECT * FROM MEMBER WHERE MONTHS_BETWEEN(SYSDATE,REGDATE) < 6;

SELECT NEXT_DAY(SYSDATE,'토') FROM DUAL;
SELECT SYSDATE, ROUND(TO_DATE('2051-02-03'),'cc'),TRUNC(TO_DATE('2051-02-03'),'cc') FROM DUAL;

SELECT NVL(TRUNC(AGE/10) * 10,'0') FROM MEMBER;
SELECT NVL2(AGE,TRUNC(AGE/10) * 10,0) FROM MEMBER;
SELECT DECODE(SUBSTR(GENDER,1,1),'남','남자아이','여','여자아이','기타') FROM MEMBER;

SELECT * FROM MEMBER ORDER BY AGE DESC;

SELECT WRITER_ID,COUNT(ID) COUNT 
FROM NOTICE 
GROUP BY WRITER_ID 
ORDER BY COUNT ASC;

/*회원별 게시글 수를 조회. 단 게시글이 2이하인 레코드만 출력*/
SELECT WRITER_ID,COUNT(TITLE) FROM NOTICE GROUP BY WRITER_ID HAVING COUNT(TITLE) <2;

SELECT ROW_NUMBER() OVER (ORDER BY HIT), ID, TITLE, WRITER_ID, REGDATE, HIT
FROM NOTICE;

SELECT * FROM MEMBER ORDER BY REGDATE DESC;

SELECT * FROM (SELECT * FROM MEMBER ORDER BY REGDATE DESC)
WHERE ROWNUM BETWEEN 1 AND 5;

/*평균나이가 20이상인 회원*/
SELECT * FROM MEMBER WHERE AGE >(SELECT AVG(AGE) FROM MEMBER);

SELECT * FROM MEMBER;
SELECT * FROM NOTICE;

SELECT * FROM MEMBER INNER JOIN NOTICE ON MEMBER.ID = NOTICE.WRITER_ID;
SELECT * FROM NOTICE N JOIN MEMBER M ON N.WRITER_ID = M.ID; 
SELECT * FROM NOTICE N FULL OUTER JOIN MEMBER M ON N.WRITER_ID = M.ID;

SELECT M.*, B.NAME BOSS_NAME
FROM MEMBER M LEFT OUTER JOIN MEMBER B ON B.ID = M.BOSS_ID;

SELECT ID, NAME FROM MEMBER
    UNION
SELECT WRITER_ID, TITLE FROM NOTICE;


CREATE VIEW NOTICE_VIEW
AS
SELECT N.ID, N.TITLE,N.WRITER_ID, N.REGDATE, N.HIT, N.FILES, COUNT(C.ID) CMT_COUNT FROM NOTICE N LEFT JOIN "COMMENT" C ON N.ID = C.NOTICE_ID GROUP BY N.ID, N.TITLE,N.WRITER_ID, N.REGDATE, N.HIT, N.FILES;

SELECT * FROM (SELECT ROWNUM NUM, n.* FROM (SELECT * FROM NOTICE_VIEW WHERE TITLE LIKE '%JDBC%' ORDER BY REGDATE DESC)n) WHERE NUM BETWEEN 1 AND 5;

INSERT INTO NOTICE(TITLE,CONTENT, WRITER_ID,PUB) VALUES('안녕하세요', '테스트입니다', 'newlec', 1);
