<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>웹사이트 제목</title>
<link rel="stylesheet" href="mainboard.css">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link
	href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap"
	rel="stylesheet">
<style>
* {
	font-family: 'Sunflower', sans-serif;
	font-weight: bolder;
	font-size: large;
}
</style>

</head>

<body>
	<div>
		<img class="logoImage"
			src="https://github.com/db-ung/web_pj/blob/main/%EC%9E%A1%EB%8F%99%EC%82%AC%EB%8B%88/%EB%A1%9C%EA%B3%A0%EB%8F%99%EA%B7%B8%EB%9D%BC%EB%AF%B8.png?raw=true"
			alt="로고 이미지">
		<h1 class="title">Ahnzwa Ssu</h1>
	</div>
	<div class="AD">
		<form action="viewBoard.jsp">
			<input type="submit" value="게시판1" name="1" style="font-size: 30px;" />
		</form>
		<form action="viewBoard.jsp">
			<input type="submit" value="게시판2" name="2" style="font-size: 30px;" />
		</form>
		<form action="viewBoard.jsp">
			<input type="submit" value="게시판3" name="3" style="font-size: 30px" />
		</form>
	</div>

	<ol class="spotlight1">
		<a>인기 게시판1</a>
		<c:forEach var="item" items="${list}">
			<li>${item.TITLE}</li>
		</c:forEach>
	</ol>

	<ol class="spotlight2">
		<a href="ppb12.do">인기 게시판2 보기</a>
	</ol>

	<ol class="spotlight3">
		<a href="ppb13.do">인기 게시판3 보기</a>
	</ol>

	<div>
		<img class="prop"
			src="data:image/jpeg;base64,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"
			style="width: 250px; height: 100px" /> <span class="nickname"><%=session.getAttribute("nickname")%></span>
		<form class="logoutButton" action="logout.do">
			<input type="submit" value="LogOut" />
		</form>
		<form class="myPageButton" action="Mypage.jsp">
			<input type="submit" value="MyPage" />
		</form>
	</div>

	<ol class="newList" id="newPostList">
		최신글
		<%
	// 세션에서 boardList 가져오기
	List<Map<String, String>> boardList = (List<Map<String, String>>) session.getAttribute("newBoardList");

	if (boardList != null && !boardList.isEmpty()) {
		for (Map<String, String> boardInfo : boardList) {
	%>
		<li><a href="detailPost.jsp"><%=boardInfo.get("tag")%> : <%=boardInfo.get("title")%></a>
		</li>
		<%
		}
		} else {
		%>
		<li>No new posts available.</li>
		<%
		}
		%>
	</ol>

	<div>
		<form action="https://www.google.com/search" method="get">
			<img class="searchengine"
				src="https://github.com/db-ung/web_pj/blob/main/%EC%9E%A1%EB%8F%99%EC%82%AC%EB%8B%88/pngwing.com.png?raw=true"
				alt="검색엔진 이미지"> <input class="searching" type="text" name="q" />
			<input class="searchbt" type="submit" value="검 색" />
		</form>
	</div>
	<script>
		//최신글 당겨오기할 스크립트
	</script>
</body>

</html>
