<%@page import="java.security.interfaces.RSAKey"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유클리드 호제법</title>
</head>
<body>
<%!
int gcd=0;
int lcm=0;
void gcdlcm(int num1,int num2){
	int min = (num1>num2)? num2 : num1;
	int max = (num1>num2)? num1 : num2;
	while(true){
		int rem = max%min;
		if(rem==0){
			gcd = min;
			lcm = (num1+ num2)/min;
			break;
		}
		max=min;
		min=rem;
	}
}
%>
	<form>
		<table style="border: 1px solid black">
			<%
		        String snum1 = request.getParameter("num1");
		        String snum2 = request.getParameter("num2");
		        if(snum1 != null && !snum1.isEmpty() && snum2 != null && !snum2.isEmpty()){
		            int num1 = Integer.parseInt(snum1);
		            int num2 = Integer.parseInt(snum2);
		            gcdlcm(num1, num2);
        		}
        	%>
			<tr>
				<td> 숫자1: </td>
				<% if(snum1==null) { %>
				<td> <intput type='text' name='num1'placeholder='숫자를 입력하세요'/> </td>
				<% }else{%>
				<td><intput type='text' name='num1'value='<%= snum1 %>'/></td>
				<%} %>
			</tr>
			<tr>
				<td> 숫자2: </td>
				<%if(snum2==null){ %>
				<td> <intput type='text' name='num2'placeholder='숫자를 입력하세요'/> </td>
				<%}else{%>
				<td><intput type='text' name='num2'value='<%=snum2%>'/></td>
				<%}%>
			</tr>
			<tr>
				<td> 최대공약수 : </td>
				<td><intput type='text' name='num3'value='<%= gcd%>' readonly/></td>
			</tr>
			<tr>
				<td> 최소공배수 : </td>
				<td><intput type='text' name='num4' value='<%= lcm%>' readonly/></td>
			</tr>
			<tr><td><input style='width:100%;'type='submit'value='실행'/></td></tr>
		</table>
	</form>
</body>
</html>