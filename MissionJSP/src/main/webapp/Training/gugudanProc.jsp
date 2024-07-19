
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String sel = request.getParameter("sel");
	String dir = request.getParameter("dir");
	String dan = request.getParameter("dan");
	String col = request.getParameter("col");
	String url;
	String key;
	
	if(sel.equals("Type1")){
		url ="gugudan1.jsp";
		key = "dan";
	}else if(sel.equals("Type2")){
		url = "gugudan2.jsp";
		key = "dir";
	}else{
		url = "gugudan3.jsp";
		key = "col";
	}
	
	request.getRequestDispatcher(url+"?"+key+"="+request.getParameter(key)).forward(request, response);
	
	%>
</body>
</html>