<%@ page import="java.sql.ResultSet"%>
<%@ page import="java.sql.Statement"%>
<%@ page import="java.sql.Connection"%>
<%@ page import="common.JDBConnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
</head>
<body>
	<h2>사용자 작성 글 목록</h2>
	<%
	//DB에 연결
		JDBConnect jdbc = new JDBConnect();
		
		//쿼리문 생성
		String sql = "select * from board where id='musthave'";
		Statement stmt = jdbc.getCon().createStatement();
		
		//쿼리 수행
		ResultSet rs = stmt.executeQuery(sql);
		
		//결과확인(웹 페이지에 출력)
		out.print("<table>");
	while(rs.next()){
		out.print("<tr>");			
		 int num = rs.getInt(1);
		String id = rs.getString("id");
		String title = rs.getString("title");
		String content = rs.getString("content");
		java.sql.Date postdate = rs.getDate("postdate");
		out.println(String.format("<td>%d</td> <td>%s</td> <td>%s</td> <td>%s</td>",num,id,title,content,postdate)); 
		out.print("</tr>");
		}
		out.print("</table>");
		
		//연결닫기
		rs.close();
		%>
</body>
</html>