CREATE TABLE USER(
	IDX INT AUTO_INCREMENT unique,   -- 아이디 고유번호
	ID varchar(255) PRIMARY KEY,				-- 유저 아이디
    PW varchar(255),				-- 유저 비밀번호
    PWQS VARCHAR(255),				-- 유저 비밀번호 찾기 질문
    PWHINT VARCHAR(255),			-- 유저 비밀번호 찾기 힌트
    HP varchar(255),      			-- 유저 휴대폰번호
    ADDRESS VARCHAR(255),       	-- 유저 주소
    NAME VARCHAR(255),				-- 유저 이름
    NICKNAME VARCHAR(255),  		-- 유저 닉네임
    FOLLOW VARCHAR(255), 			-- 팔로우
    FOLLOWER VARCHAR(255),   		-- 팔로워
    lastenter date,					-- 마지막 접속일자
    deleteday date,					-- 탈퇴신청일
    deletecheck int					--  탈퇴여부 확인
);

CREATE TABLE BOARD(
IDX INT AUTO_INCREMENT PRIMARY KEY,  	-- 게시글 고유번호
ID VARCHAR(255),						-- 작성자 아이디	
NICKNAME VARCHAR(255),            	  	-- 작성자 닉네임
TITLE VARCHAR(255),   					-- 타이틀
CONTENT VARCHAR(5000),  					-- 내용
DATE DATETIME, 							-- 날짜
HIT INT, 								-- 조회수 
FILE VARCHAR(255), 						-- 업로드 파일
isgood int,								-- 좋아요 수
FOREIGN KEY (USER_ID) REFERENCES USER(IDX)

);

CREATE TABLE BOARD_REPLY(
 IDX INT AUTO_INCREMENT PRIMARY KEY, 	-- 댓글고유번호 							
 ID VARCHAR(255),  						-- 작성자 아이디
 NICKNAME VARCHAR(255), 				-- 작성자 닉네임
 CONTENT VARCHAR(500),              	-- 내용
 DATE DATETIME, 						-- 일자
 isgood int,							-- 좋아요 수
 FOREIGN KEY (USER_ID) REFERENCES USER(IDX)

);



-- drop table user;
-- DROP TABLE BOARD;
-- DROP TABLE BOARD_REPLY;
