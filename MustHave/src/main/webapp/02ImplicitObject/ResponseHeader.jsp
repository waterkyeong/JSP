<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//응답 헤더에 추가할 값 준비
SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm");
long add_date = s.parse(request.getParamater("add_date")).getTime();
int add_int = Integer.parseInt(request.getParameter("add_int"));
Stirng add_str = request.getParameter("add_str");

response.addDateHeader("myBirthday", add_date);
response.addIntHeader("myNumber", add_int);
response.addIntHeader("myNumber", 1004);
response.addHeader("myName",add_str);
response.setHeader("myName","안중근");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 -  response</title>
</head>
<body>

</body>
</html>