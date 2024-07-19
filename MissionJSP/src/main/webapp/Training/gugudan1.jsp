<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gugudan1</title>
</head>
<body>
<%
int dan =2;
try {
	dan = Integer.parseInt(request.getParameter("dan"));
} catch (Exception e) {
}
	out.println(dan+"단"+"<br/>");
	for(int i=1; i<10;i++){
		out.println(dan + "*"+i+"="+(dan*i)+"<br/>");
	}
%>
</body>
</html>