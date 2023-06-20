CREATE DATABASE ingatlan_db;

USE ingatlan_db;


CREATE TABLE Ingatlan(
tulajdonos varchar(30) not null,
hrsz varchar(10) not null,
alapterulet int not null,
becsultertek int not null);


INSERT INTO Ingatlan VALUES('Magyar Endre','125/2',170,75000000);
INSERT INTO Ingatlan VALUES('Kiss Lilla','3181/1',110,45000000);
INSERT INTO Ingatlan VALUES('Tóth Eszter','11055',80,32000000);
INSERT INTO Ingatlan VALUES('Fekete Benedek','1101/1',100,40000000);
INSERT INTO Ingatlan VALUES('Nagy Andrea','2345',135,59000000);



