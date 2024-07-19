<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>gugudan1-1</title>
</head>
<body>
<% 
String dir = "hor"; 
try {
	dir=request.getParameter("dir");
	if(dir==null)
		dir = "hor";
} catch (Exception e) {
}
	
	if(dir.equals("ver")){
	for(int dan =2; dan<=9; dan++){
		out.print(dan+"단"+"<br/>");
		for(int i=1; i<10;i++){
			out.print(dan + "*"+i+"="+(dan*i)+"<br/>");
		}
	}
	}else if(dir.equals("hor")){
		for(int i=1; i<10;i++){
			for(int dan =2; dan<=9; dan++){
				out.println(dan + "*"+i+"="+(dan*i)+"\t");
			}
				out.print("<br/>");
		}
	}
%>
</body>
</html>