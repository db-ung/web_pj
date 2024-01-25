<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>내 정보 확인</h1>
	<%
		HttpSession hs = request.getSession();
		out.println(hs.getAttribute("id"));
		out.println(hs.getAttribute("nickname"));
		out.println(hs.getAttribute("name"));
		out.println(hs.getAttribute("address"));
		out.println(hs.getAttribute("tel"));
		out.println(hs.getAttribute("email"));

		
	%>
</body>
</html>