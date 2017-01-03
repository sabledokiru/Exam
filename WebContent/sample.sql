CREATE TABLE product(
productNum NUMBER PRIMARY KEY,
productName VARCHAR2(50) not null,
brand VARCHAR2(30) not null,
content CLOB,
price NUMBER,
regdate DATE
);

CREATE SEQUENCE product_seq NOCACHE;

create table Members(
MemberId VARCHAR2(50) PRIMARY KEY,
MemberPwd VARCHAR2(50) NOT NULL,
MemberEmail VARCHAR2(50) NOT NULL UNIQUE,
MemberPhone VARCHAR2(50) NOT NULL,
MemberAddr VARCHAR2(100) NOT NULL,
REGDATE DATE
);
