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
int col =4;
try {
	col = Integer.parseInt(request.getParameter("col"));
} catch (Exception e) {
}	
%>
<div>
<%
for(int dan =2; dan<=9; dan+=col)
	for(int i=1; i<10;i++)
		for(int j=0; j<col;j++)
			if(0<dan+j)
			out.print("");
			else
				if(i==0)
					out.print("<h2>"+dan+j+"단"+"</h2>");
				else
					out.print(String.format("%d*%d=%d", dan+j,i,(dan+j)*i));
%>
</div>
</body>
</html>