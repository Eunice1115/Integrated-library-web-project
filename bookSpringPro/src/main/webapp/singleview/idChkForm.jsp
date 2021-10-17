<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post"
		action="<%=request.getContextPath()%>/member/idChkPro"
		name="userInfo" id="form">
		아이디 중복 확인
		<br>
		
		<input type="text" name="memberid" maxlength="50" class="text"/>
		<input type="submit" value="확인" >
		<input type="submit" value="닫기" onclick="self.close()">
		
	</form>
</body>
</html>