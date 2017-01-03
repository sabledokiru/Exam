CREATE TABLE product(
productNum NUMBER PRIMARY KEY,
productName VARCHAR2(50) not null,
brand VARCHAR(30) not null,
delivery VARCHAR(20) not null,
regdate DATE
);

CREATE SEQUENCE product_seq NOCACHE;

create table Members
(userId VARCHAR2(50) PRIMARY KEY,
userPwd VARCHAR2(50) NOT NULL,
userEmail VARCHAR2(50) NOT NULL UNIQUE,
userPhone VARCHAR2(50) NOT NULL,
userAddr VARCHAR2(100) NOT NULL,
REGDATE DATE);
