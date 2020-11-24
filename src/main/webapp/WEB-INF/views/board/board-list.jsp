<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
	<tr>
		<th>글번호</th>
		<th>글 제목</th>
		<th>글 내용</th>
	</tr>
		<c:forEach items="${boardList}" var="board" >
	<tr>
			<td>${board.HB_NO}</td>
			<td><a href="/board/view/${board.HB_NO}">${board.HB_TITLE}</a></td>
			<td>${board.HB_CONTENT}</td>
	</tr>
		</c:forEach>
	
</table>
</body>
</html>