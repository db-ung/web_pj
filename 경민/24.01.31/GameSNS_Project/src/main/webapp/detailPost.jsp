<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
<link rel="stylesheet" href="newPost_page.css">
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="main.html">테스트용 사이트</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item active">
                    <a class="nav-link" href="board1.html">게시판 1</a>
                </li>
            </ul>
        </div>
    </nav>
<form action="insert.doPosting">
   <div class="ground">
      <ul>
      <li><label>게시글 고유 번호 : <%=session.getAttribute("IDX")%></label><br>
      <label>작성일 : "여기에 날짜"</label><br>
      <label>작성자 : "여기에 작성자"</label></li>
         <li>태그<span class="bx1"><p class="txt">"여기에 태그"</p></span></li>
         <li>제목<span class="bx1"><p class="txt">"여기에 제목"</p></span></li>
         <li>내용<span class="bx1"><p class="txt">"여기에 내용"</p></span></li>
      </ul>
      <button type="submit" class="finish" id="postSubmit">제출하기</button>
      <button type="button" class="cancle" onClick="location.href='main.html'">취소</button>
   </div>
</form>
</body>
</html>