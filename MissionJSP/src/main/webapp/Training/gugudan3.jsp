<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gugudan2</title>
<style>
	/* .container {
			width:500px;
			display:flex; 
			height: 100vh;
			justify-content:center;
			align-items:center; 
		} */
</style>
</head>
<body>
<div class="container">
<%
int col =2;
try {
	col = Integer.parseInt(request.getParameter("col"));
} catch (Exception e) {
}	

for(int i=1; i<10;i++){
	for(int dan =2; dan<col+2; dan++){
		out.println(dan + "*"+i+"="+(dan*i)+"\t");
	}
		out.print("<br/>");
}
for(int i=1; i<10;i++){
	for(int dan =col+2; dan<10; dan++){
		out.println(dan + "*"+i+"="+(dan*i)+"\t");
	}
		out.print("<br/>");
}

/* for(int i=1; i<10;i++){
	for(int dan =2; dan<col+2; dan++){
		out.println(dan + "*"+i+"="+(dan*i)+"\t");
	}
		out.print("<br/>");
}
for(int i=1; i<10;i++){
	for(int dan =col+2; dan<10; dan++){
		out.println(dan + "*"+i+"="+(dan*i)+"\t");
	}
		out.print("<br/>");
} */
%>
</div>
</body>
</html>