<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 탈퇴 비밀번호 확인</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberCss/deleteForm.css">
</head>

<body>
<div  id="box">
	<form name="f"
		action="<%=request.getContextPath()%>/member/memberDeletePro"
		method="post" class="form">
		
		<input type="hidden" name="userid" value="${member.memberid}">
			<h3>회원정보 비밀번호 입력</h3>
			
		<table class="table">
			
			<tr>
				<td class="name">이름</td>
				<td class="data">${member.name}</td>
			</tr>
			<tr>
				<td class="name">비밀번호</td>
				<td class="data"><input type="password" name="pass"></td>
			</tr>
			<tr>
				<td colspan="2" class="button"><input type="submit" value="탈퇴하기"></td>
			</tr>
			
		</table>
	</form>
</div>
</body>
</html>
