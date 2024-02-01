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
<title>게시물 상세보기</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
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
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="mainboard.jsp">테스트용 사이트</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link" href="board1.html"
					id="board1">게시판 1</a></li>
			</ul>
		</div>
	</nav>
	<form action="mainboard.jsp">
		<input type="submit" value="메인가기">
	</form>
	<form action="viewPL.doPosting">
		<div class="container">
			<div class="card">
				<div class="card-header">
					<h5 class="card-title" id="postTitle"></h5>
				</div>
				<div class="card-body">
					<p class="card-text" id="postContent">
					<ul>
						<%
						// 세션에서 boardList 가져오기
						List<Map<String, String>> boardList = (List<Map<String, String>>) session.getAttribute("boardList");

						if (boardList != null && !boardList.isEmpty()) {
							for (Map<String, String> boardInfo : boardList) {
						%>
						<li><strong><%=boardInfo.get("tag")%></strong>: <%=boardInfo.get("title")%></li>
						<%
						}
						} else {
						%>
						<li>No new posts available.</li>
						<%
						}
						%>

					</ul>
					</p>
					<button class="btn btn-danger delete-btn">삭제</button>
					<a href="edit.jsp" class="btn btn-warning edit-btn">수정</a> <a
						href="board1.jsp" class="btn btn-primary back-btn">돌아가기</a>
				</div>
			</div>
		</div>
	</form>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script src="script.js"></script>

</body>
</html>