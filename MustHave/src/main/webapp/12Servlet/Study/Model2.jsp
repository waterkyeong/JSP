<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>애너테이션으로 DB 가져오기</h2>
	<!-- 여기서 foreach el 두개 사용해서 table로 출력 -->
<%-- 	<strong >${message }</strong> --%>
<table border="1">
<c:forEach items="${ message}" var="dto">
	<tr>
		<td>${ dto.num}</td>
		<td>${ dto.title}</td>
		<td>${ dto.id}</td>
		<td>${ dto.postdate}</td>
		<td>${ dto.visitcount}</td>
	</tr>
</c:forEach>
</table>
		<a href="./Model2.do?table=member" onclick="requestAction(this.form,1);">member</a>
		&nbsp;&nbsp; 
		<a href="./Model2.do?table=board" onclick="requestAction(this.form,2);">board</a>
</body>
</html>