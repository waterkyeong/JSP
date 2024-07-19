<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - Response</title>
</head>
<body>
<%
String id = request.getParameter("user_id");
String pwd = request.getParameter("user_pwd");
if (id.equalsIgnoreCase("must") && pwd.equalsIgnoreCase("1234")){
	response.sendRedirect("ResponseWelcome.jsp");							//응답을 한번 더 주고받는다.
} else{
	request.getRequestDispatcher("ResponseMain.jsp?loginErr=1")
		.forward(request, response);										//서버내부에서의 이동이기때문에 응답이 한번만 한다. 자세한건 ch3에서
}
%>
</body>
</html>