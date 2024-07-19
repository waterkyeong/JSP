<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String popupMode="on";    //레이어 팝업창 띄울지 여부

Cookie[] cookies = request.getCookies();		//쿠키를 읽어 popupmode값 설정
if(cookies != null){
	for(Cookie c : cookies) {
		String cookieName= c.getName();
		String cookieValue = c.getValue();
		if(cookieName.equals("PopupClose")){		//"popupClose" 쿠키가 존재하면
			popupMode = cookieValue;				//popupmode의 값 갱신
		}
	}
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>🍪쿠키를 이용한 팝업 관리🍪 </title>
<!-- css로 레이어 팝업창의 위치 지정 -->
<style>    
	div#popup{
		position: absolute; top:100px; left:50px; color:yellow;
		width:270px; height:100px; background-color:gray;
	}
	div#popup>div{
		position: relative; background-color:#ffffff; top:0px;
		border:1px solid gray; padding:10px; color:black;
	}
</style>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.0/jquery.min.js"></script>
<script>
$(function(){
	$('#closeBtn').click(function(){   //닫기 버튼(id="closeBtn")을 누르면
		$('#popup').hide();			  // 팝업창(id="popup")을 숨김 처리합니다.  > 닫기 버튼 누르면 실행되는 함수
		var chkVal = $("input:checkbox[id=inactiveToday]:checked").val();     //체크 여부
		if(chkVal == 1){
			$.ajax({
				url : './PopupCookie.jsp',
				type : 'get',
				data : {inactiveToday : chkVal},
				dataType : "text",
				succes : function(resData){
					if(resData !='')location.reload();
				}
			})
		}
	})
})
</script>
</head>
<body>
<h2>🍪팝업 메인 페이지</h2>
<%
	for(int i = 1; i<=10;i++){
		out.print("현재 팝업창은"+popupMode+"상태입니다.<br/>");
	}

	if(popupMode.equals("on")){    //popupmode값이 "on"일 때만 팝업창 표시
%>
	<div id="popup">				<!-- 공지사항 팝업 화면 -->
		<h2 align="center">공지사항 팝업입니다.</h2>
		<div align="right"><form name="popFrm">
			<input type="checkbox" id="inactiveToday" value="1"/>  <!-- 체크박스 -->
			🍪하루 동안 열지 않음
			<input type="button" id="closeBtn" value="닫기"/>			<!-- 닫기 버튼 -->
		</form></div>
	</div>
<%
} 
%>	
</body>
</html>