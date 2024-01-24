<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h3>회원탈퇴</h3>
	<form id="deleteForm" action="delete.do">
		아이디: <label id="id" name="deleteid"><%= session.getAttribute("id") %></label><br>
		비밀번호: <input type="text" id="pw" name="deletepw"/><br>
		<input type="submit" value="회원탈퇴"/>
	</form>
</body>

</html>
