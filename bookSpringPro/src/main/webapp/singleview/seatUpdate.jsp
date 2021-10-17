<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<script>
function closeTabClick(){
	window.close();
}

</script>

<body>

<div id="box">


<form method="post" action="<%=request.getContextPath() %>/seat/seatUpdatePro" name="userInfo"
		id="form">
<input type="hidden" name="memberid" value="${memberid}">
<h2>연장하기</h2>
		
<table class="table">

	<tr>
		<td>아이디 : ${memberid}
		</td>
	</tr>
	<tr>
		<td>비밀번호 :
		<input type="password" name="pass" maxlength="50" class="text">
		</td>
	</tr>
</table>

	<input type="submit" value="연장">
	<input type="submit" value="닫기" onclick="closeTabClick()">


</form>

</div>
</body>
</html>