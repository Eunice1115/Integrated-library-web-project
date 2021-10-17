<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function closeTabClick(){
	window.close();
}

</script>
</head>

<body>

<div id="box">


<form method="post" action="<%=request.getContextPath() %>/seat/seatDeletePro" name="userInfo"
		id="form">
<h2>퇴실하기</h2>
		
<table class="table">

<tr>
	<td>아이디
	<input type="text" name="memberid" maxlength="50" class="text" value='${memberid}'>
	</td>
</tr>

<tr>
	<td>비밀번호 :
	<input type="password" name="pass" maxlength="50" class="text">
	</td>
</tr>

<td>
	<input type="submit" value="퇴실">
	<input type="submit" value="닫기" onclick="closeTabClick()">
</td>



</table>

</form>

</div>
</body>
</html>