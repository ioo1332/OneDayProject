--관리자 영역 OneDay Project table sapce생성

CREATE TABLESPACE FoodDB
DATAFILE 'C:/oraclexe/data/food.dbf'
SIZE 1M AUTOEXTEND ON NEXT 1K;

CREATE USER food IDENTIFIED BY food
DEFAULT TABLESPACE FoodDB;

GRANT DBA TO food;

