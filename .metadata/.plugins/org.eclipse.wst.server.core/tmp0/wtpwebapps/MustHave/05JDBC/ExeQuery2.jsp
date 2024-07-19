<%@ page import="java.sql.ResultSet" %>
<%@ page import="java.sql.Statement" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="common.JDBConnect" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JDBC</title>

</head>
<body>
	<h2>사용자 작성 글 목록(parameter로 id받기)</h2>
	<%
	//DB에 연결
		JDBConnect jdbc = new JDBConnect();
		
		//쿼리문 생성
		String sql = "select * from board where ?";
		Statement stmt = jdbc.getCon().createStatement();
		
		//쿼리 수행
		ResultSet rs = stmt.executeQuery(sql);
		
// 		String id=request.getParameter("id");
		
		
		//결과확인(웹 페이지에 출력)
		while(rs.next()){
			int num = rs.getInt(1);
			String id = rs.getString("id");
			String title = rs.getString("title");
			String content = rs.getString("content");
			java.sql.Date postdate = rs.getDate("postdate");
			
			out.println(String.format("%d %s %s %s %s",num,id,title,content,postdate)+"<br/>");
		}
		
		//연결닫기
		jdbc.close();
	%>
</body>
</html>