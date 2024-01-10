CREATE TABLE USER(
IDX INT AUTO_INCREMENT PRIMARY KEY,   -- 아이디 고유번호
ID varchar(255),				-- 유저 아이디
PW varchar(255),				-- 유저 비밀번호
PWQS VARCHAR(255),				-- 유저 비밀번호 찾기 질문
PWHINT VARCHAR(255),			-- 유저 비밀번호 찾기 힌트
HP varchar(255),      			-- 유저 휴대폰번호
ADDRESS VARCHAR(255),       	-- 유저 주소
 NAME VARCHAR(255),				-- 유저 이름
NICKNAME VARCHAR(255),  		-- 유저 닉네임
FOLLOW VARCHAR(255), 			-- 팔로우
FOLLOWER VARCHAR(255)   		-- 팔로워
    
);

CREATE TABLE BOARD(
IDX INT AUTO_INCREMENT PRIMARY KEY,  	-- 게시글 고유번호
ID VARCHAR(255),						-- 작성자 아이디	
NICKNAME VARCHAR(255),            	  	-- 작성자 닉네임
TITLE VARCHAR(255),   					-- 타이틀
CONTENT VARCHAR(255),  					-- 내용
DATE DATETIME, 							-- 날짜
HIT INT, 								-- 조회수 
FILE VARCHAR(255), 						-- 업로드 파일
FOREIGN KEY (USER_ID) REFERENCES USER(IDX)
);

CREATE TABLE BOARD_REPLY(
 IDX INT AUTO_INCREMENT PRIMARY KEY, 	-- 댓글고유번호
 CON_NUM INT, 							-- 댓글번호
 ID VARCHAR(255),  						-- 작성자 아이디
 NICKNAME VARCHAR(255), 				-- 작성자 닉네임
 CONTENT VARCHAR(255),              	-- 내용
 DATE DATETIME, 						-- 일자
 FOREIGN KEY (USER_ID) REFERENCES USER(IDX)

);



-- drop table user;
-- DROP TABLE BOARD;
-- DROP TABLE BOARD_REPLY;
