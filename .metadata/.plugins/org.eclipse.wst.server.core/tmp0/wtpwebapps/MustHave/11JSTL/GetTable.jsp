<%@page import="model1.board.BoardDTO"%>
<%@page import="model1.board.BoardDAO"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<%
//DAO를 생성해 DB에 연결
BoardDAO dao = new BoardDAO(application);

//사용자가 입력한 검색 조건을 Map에 저장
Map<String, Object> param = new HashMap<String, Object>();

String searchField = request.getParameter("searchField");
String searchWord = request.getParameter("searchWord");
if(searchWord!=null){
	param.put("searchField", searchField);
	param.put("searchWord", searchWord);
}

int totalCount = dao.selectCount(param); //게시물 수 확인
List<BoardDTO> boardList = dao.selectList(param);//게시물 목록 받기
dao.close();//DB연결 닫기
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 게시물 목록 테이블(표) -->
	<table border="1" width="90%">
		<!-- 각 칼럼의 이름 -->
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="15%">작성자</th>
			<th width="10%">조회수</th>
			<th width="15%">작성일</th>
		</tr>
		<!-- 목록의 내용 -->
		<!--게시물이 하나도 없을때-->
		<c:if test="${boardList.isEmpty() }" var="result">
		<tr>
			<td colspan="5" align="center">
				등록된 게시물이 없습니다. :)
			</td>
		</tr>
		</c:if>
		<!-- 게시물이 있을때 DB 연결이 안된것 같음!!!! 확인해보자,,, -->  
		<c:if test="${not result }">
		<c:forEach var="BoardDTO dto" items="<%=boardList %>" varStatus="loop">
		<tr align="center">
			<td>${loop.count}</td> <!-- 게시물 번호 -->
			<td align="left">${loop.}</td>
<%-- 			<td align="center">${loop.id}</td> --%>
<%-- 			<td align="center">${loop.updateVisitcount()}</td> --%>
<%-- 			<td align="center">${loop.getPostdate()}</td> --%>
		</tr>
		</c:forEach>
		</c:if>
	</table>
</body>
</html>