<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="delete_page.css">
    <title>탈퇴하시겠습니까?</title>
</head>
<body>
    <img class="logoto" src="https://github.com/db-ung/web_pj/blob/main/%EC%9E%A1%EB%8F%99%EC%82%AC%EB%8B%88/%EB%A1%9C%EA%B3%A0-removebg-preview.png?raw=true"/>
    <div class="back">
        <form action = "delete.do">
	        <div>
	            <img class="pimg" src="https://github.com/db-ung/web_pj/blob/main/%EC%9E%A1%EB%8F%99%EC%82%AC%EB%8B%88/%EB%A1%9C%EA%B3%A0%EB%8F%99%EA%B7%B8%EB%9D%BC%EB%AF%B8.png?raw=true">
	            <p class="nickname" id="out_nick" name="out_nick"><%=session.getAttribute("nickname")+"님"%></p>
	        </div>
	        <div>
	            <p class="pw_txt">비밀번호 : </p>
	            <input type="text" name = "deletepw" class="pw_bx">
	        </div>
	        <div>
	            <button type="submit" class="true_bt">탈퇴하기</button>
	        </div>
        </form>
	<button onclick="location.href='Mypage.jsp'" class="false_bt">취소</button>
    </div>
    
</body>
</html>
