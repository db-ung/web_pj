<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="MyPage.css">
    <title>Document</title>
</head>
<body>
    <div class="back">
        <img class="logo" src="https://github.com/db-ung/web_pj/blob/main/%EC%9E%A1%EB%8F%99%EC%82%AC%EB%8B%88/%EB%A1%9C%EA%B3%A0%EB%8F%99%EA%B7%B8%EB%9D%BC%EB%AF%B8.png?raw=true"/> 
        <ul>
            <li>아이디<span class="bx"><p class="txt"><%=session.getAttribute("id")%></p></span></li>
            <li>이름<span class="bx"><p class="txt"><%=session.getAttribute("name")%></p></span></li>
            <li>주소<span class="bx"><p class="txt"><%=session.getAttribute("address")%></p></span></li>
            <li>전화번호<span class="bx"><p class="txt"><%=session.getAttribute("tel")%></p></span></li>
            <li>이메일 주소<span class="bx"><p class="txt"><%=session.getAttribute("email")%></p></span></li>
            <li>생년월일<span class="bx"><p class="txt"><%=session.getAttribute("birth")%></p></span></li>
        </ul>
        <button onclick="location.href='EditUser.jsp'" class="fix">수정하기</button>
        <button onclick="location.href='delete.jsp'" class="userDel">회원탈퇴</button>
        <button class="bback" onclick="location.href='main.html'">뒤로가기</button>
    </div>
</body>
</html>
