<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MemberAuth.jsp</title>
</head>
<body>
	<h2>MVC 패턴으로 회원인증하기</h2>
	<p>
		<strong>${authMessage }</strong>
		<br/>
		<a href="./MemberAuth.mvc?id=nakja&pass=1234">회원인증(관리자)</a>
		&nbsp;&nbsp;
		<a href="./MemberAuth.mvc?id=musthave&pass=1234">회원인증(회원)</a>
		&nbsp;&nbsp;
		<a href="./MemberAuth.mvc?id=stranger&pass=1234">회원인증(비회원)</a>
	</p>
	<form action="./MemberAuth.mvc" method="post" name="loginFrm" onsubmit="return validateForm(this);">
	아이디 : <input type="text" name="id" /><br/>
	패스워드 : <input type="password" name="pass"/><br/>
	<input type="submit" value="로그인"/>
	</form>
</body>
</html>