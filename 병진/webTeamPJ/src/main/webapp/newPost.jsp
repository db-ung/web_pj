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
         <li>태그
            <select name="tag" class="tag">
               <option>기타</option>
			   <option>LoL</option>
			   <option>FIFA</option>
			   <option>메이플스토리</option>
			   <option>던전앤파이터</option>
			   <option>몬스터헌터</option>
			   <option>PalWorld</option>
            </select>
         </li>
         <li>제목</li>
            <input type="text" class="title" id="TITLE" name="TITLE"/>
         <li>내용</li>
            <textarea class="post" placeholder="내용 입력하삼" id="CONTENT" name="CONTENT"></textarea>
      </ul>
      <button type="submit" class="finish" id="postSubmit">제출하기</button>
      <button type="button" class="cancle" onClick="location.href='mainboard.jsp'">취소</button>
   </div>
</form>
</body>
</html>