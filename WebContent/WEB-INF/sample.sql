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
CREATE TABLE evaluation(
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


-- 큐엔에이 테이블 and 시퀀스
CREATE sequence QA_seq nocache;

CREATE sequence QAnswer_seq nocache;

CREATE TABLE QA_writer(
num number primary key,
mainquestion varchar2(100),
detailquestion varchar2(500),
writer varchar2(50),
secret varchar2(10),
regdate date);

CREATE TABLE QA_answer(
num number primary key,
writer varchar2(50),
content varchar2(500),
ref_num number,
regdate date);





