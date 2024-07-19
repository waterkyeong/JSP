<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GugudanForm</title>
<!--  <style>
	div#dd{
		position: absolute; top:100px; left:50px; color:yellow;
		width:270px; height:100px; background-color:gray;
	}
	div#popup>div{
		position: relative; background-color:#ffffff; top:0px;
		border:1px solid gray; padding:10px; color:black;
	}
</style>-->
</head>
<body>
	<h2>구구단</h2>
	<form action="gugudanProc.jsp" method="get">
	<div style="flex">
		Type1 <input type="radio" name="sel" value="Type1"/>
		Type2 <input type="radio" name="sel" value="Type2"/>
		Type3 <input type="radio" name="sel" value="Type3"/>
	</div>
	<div style="flex">
		Ver <input type="radio" name="dir" value="ver"/>
		Hor <input type="radio" name="dir" value="hor"/>
	</div>
		<input type="number" name="dan" value="dan"/>단
		<input type="number" name="col" value="col"/>열
	<div>
		<br/>
		<input type="submit" />
	</div>
	</form>
	
</body>
</html>