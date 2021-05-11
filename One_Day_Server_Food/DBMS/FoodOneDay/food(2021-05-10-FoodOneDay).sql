--food OneDayProject

CREATE TABLE tbl_foods(
    fd_fcode	CHAR(7)		PRIMARY KEY,
    fd_fname	NVARCHAR2(100) NOT NULL,	
    fd_year	NUMBER	NOT NULL	,
    fd_ccode	CHAR(8)	NOT NULL,	
    fd_code	CHAR(8)	NOT NULL	,
    fd_serve	NUMBER	NOT NULL,	
    fd_gram	NUMBER	NOT NULL	,
    fd_kcal	NUMBER	NOT NULL	,
    fd_protein	NUMBER	NOT NULL,	
    fd_fat	NUMBER	NOT NULL	,
    fd_crbhy	NUMBER	NOT NULL,	
    fd_sugars	NUMBER	NOT NULL	
);
DROP TABLE tbl_foods;

CREATE TABLE tbl_company(
    cp_ccode	CHAR(8)	PRIMARY KEY,
    cp_cname	NVARCHAR2(100)	NOT NULL
);
DROP TABLE tbl_company;

CREATE TABLE tbl_items(
    i_code	CHAR(8)	PRIMARY KEY,
    i_name	NVARCHAR2(20)	NOT NULL
);
DROP TABLE tbl_items;

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_company
FOREIGN KEY (fd_ccode)
REFERENCES tbl_company(cp_ccode);

ALTER TABLE tbl_foods
DROP CONSTRAINT fk_company;

ALTER TABLE tbl_foods
ADD CONSTRAINT fk_items
FOREIGN KEY (fd_code)
REFERENCES tbl_items(i_code);

ALTER TABLE tbl_foods
DROP CONSTRAINT fk_items;

SELECT 
    FD.fd_fcode	AS 식품코드,
    fd.fd_fname	AS 식품명,
    FD.fd_year AS 출시연도,
    fd.fd_ccode	AS 제조사코드,
    cp.cp_cname AS 제조사명,
    fd.fd_code	AS 분류코드,
    i.i_name AS 분류명,
    FD.fd_serve AS 제공량,
    FD.fd_gram	AS 총내용량,
    FD.fd_kcal	AS 에너지,
    FD.fd_protein	AS 단백질,
    FD.fd_fat	AS 지방,
    FD.fd_crbhy AS 탄수화물,
    FD.fd_sugars AS 당류
        FROM tbl_foods FD
            LEFT JOIN tbl_company CP
                ON FD.fd_ccode=CP.cp_ccode
            LEFT JOIN tbl_items I
                ON FD.fd_code=I.i_code
;

CREATE VIEW view_식품정보 AS(
SELECT 
    FD.fd_fcode	식품코드,
    fd.fd_fname	식품명,
    FD.fd_year 출시연도,
    fd.fd_ccode	제조사코드,
    cp.cp_cname 제조사명,
    fd.fd_code	분류코드,
    i.i_name 분류명,
    FD.fd_serve 제공량,
    FD.fd_gram	총내용량,
    FD.fd_kcal	에너지,
    FD.fd_protein	단백질,
    FD.fd_fat	지방,
    FD.fd_crbhy 탄수화물,
    FD.fd_sugars 당류
        FROM tbl_foods FD
            LEFT JOIN tbl_company CP
                ON FD.fd_ccode=CP.cp_ccode
            LEFT JOIN tbl_items I
                ON FD.fd_code=I.i_code
);

CREATE TABLE tbl_myfoods(
    mf_seq	    NUMBER		PRIMARY KEY,
    mf_date	    CHAR(10)	NOT NULL,	
    mf_pcode	CHAR(8)	    NOT NULL,	
    mf_take	    NUMBER	    NOT NULL	
);

ALTER TABLE tbl_myfoods
ADD CONSTRAINT fk_foods
FOREIGN KEY(mf_pcode)
REFERENCES tbl_foods(fd_fcode);

ALTER TABLE tbl_myfoods
DROP CONSTRAINT fk_foods;


CREATE SEQUENCE seq_myfoods
START WITH 1
INCREMENT BY 1;

DROP SEQUENCE seq_myfoods;

INSERT INTO tbl_myfoods
VALUES(seq_myfoods.NEXTVAL,'2021-05-09','PD00017',4);

CREATE VIEW view_식품섭취정보 AS
(
    SELECT MF.mf_date  날짜,
           F.fd_fname  식품이름,
           MF.mf_take  섭취량,
           MF.mf_take * F.fd_gram  내용량,
           MF.mf_take * F.fd_kcal  총에너지,
           MF.mf_take * F.fd_protein  총단백질,
           MF.mf_take * F.fd_fat  총지방,
           MF.mf_take * F.fd_crbhy  총탄수화물,
           MF.mf_take * F.fd_sugars  총당류
    FROM tbl_myfoods MF
        LEFT JOIN tbl_foods F
            ON MF.mf_pcode = F.fd_fcode
);            

