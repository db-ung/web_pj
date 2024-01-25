<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 찾기</title>
    <link rel="stylesheet" href="Search_id.css">
</head>
<body>
    <div class="box">
        <img src="https://github.com/db-ung/web_pj/blob/main/%EC%9E%A1%EB%8F%99%EC%82%AC%EB%8B%88/%EB%A1%9C%EA%B3%A0-removebg-preview.png?raw=true" class="picture">
        <form action="findPw.do" method="post">
            <div>              
                <p class="name_box_line2" id="name" name="name">찾은 아이디 : <%=session.getAttribute("id") %></p>
            </div>
            <ul>
                <div>
                    <li class="id_search2">비밀번호 찾으러 가시겠습니까?<a href="Search_pw.html" class="sign_up_txt">비밀번호 찾기</a></li>
                </div>
            </ul>
        </form>
    </div>
</body>
</html>
