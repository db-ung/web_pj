<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>게시글 번호</th>
			<th>제목</th>
			<th>내용</th>
			<th>조회수</th>
			<th>게시 시간</th>
		</tr>
		<c:forEach items="${postList}" var="post">
			<tr>
				<td>${post.post_no}</td>
				<td>${post.post_title}</td>
				<td>${post.post_content}</td>
				<td>${post.visit_cnt}</td>
				<td>${post.post_uploadtime}</td>
			</tr>
		</c:forEach>
	</table>

	<a href="main.html">뒤로가기</a>
</body>
</html>
