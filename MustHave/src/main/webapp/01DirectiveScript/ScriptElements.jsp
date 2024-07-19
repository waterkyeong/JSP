<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%!//선언부(메서드 선언)
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	public int mul(int num1, int num2) {
		return num1 * num2;
	}%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트 요소</title>
</head>
<body>
	<%
	int result1;
	int result2;

	try {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));

		result1 = add(num1, num2); //스크립틀릿(자바 코드)
		result2 = mul(num1, num2); //스크립틀릿(자바 코드)
	} catch (Exception e) {
		result1 = 0;
		result2 = 0;
	}
	%>
	덧셈 결과 1: <%=result1%> <br /> <!-- 표현식(변수)-->
	곱셈 결과 1-1: <%=result2%> <br /> <!-- 표현식(변수)-->
	덧셈 결과 2: <%=add(30, 40)%> <!-- 표현식(메서트 호출)-->
</body>
</html>