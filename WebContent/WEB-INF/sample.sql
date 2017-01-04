CREATE TABLE product(
productNum NUMBER PRIMARY KEY,
productName VARCHAR2(50) not null,
brand VARCHAR2(30) not null,
content CLOB,
price NUMBER,
viewCount NUMBER,
regdate DATE,
saveFileName VARCHAR2(100) NOT NULL,
fileSize NUMBER NOT NULL
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

-- 상품평 테이블
CREATE TABLE evalutaion(
evaNum NUMBER PRIMARY KEY,
productNum NUMBER NOT NULL,	-- 특정상품에 대한 상품평을 불러오기 위한 칼럼
evaTitle VARCHAR2(100) NOT NULL,
evaWriter VARCHAR2(50) NOT NULL,
evaContent CLOB NOT NULL,
regdate DATE
);

-- 상품평 댓글 테이블
CREATE TABLE evaComment(
comNum NUMBER PRIMARY KEY,	-- 덧글의 글 번호
comWriter VARCHAR2(100),
comContent VARCHAR2(500),
comTarget_id VARCHAR2(100),	-- 덧글의 대상이 되는 아이디
comRef_group NUMBER,	-- 덧글 그룹(원 글의 num과 같음)
comComment_group NUMBER,	-- 덧글 내에서의 그룹
regdate DATE
);
-- 상품평 시퀀스
CREATE SEQUENCE eva_comment_seq NOCACHE;