<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberCss/memberUpdate.css">
</head>

<body>

<div id="box ">
	<form action="<%=request.getContextPath() %>/member/memberUpdatePro" 
	name="f" method="post" class="form">
		<input type="hidden" name="userid" value="${member.memberid}">
		
		<h3>정보수정</h3>
		
		<br>
		
		<table class="table">
			<tr>
				<td class="name">아이디</td>
				<td class="data">${member.memberid}</td>
			</tr>
			
			<tr>
				<td class="name">비밀번호</td>
				<td class="data"><input type="password" name="pass"></td>
			</tr>
			
			<tr>
				<td class="name">이름</td>
				<td class="data"><input type="text" name="name"    value="${member.name}"></td>
			</tr>	
					
			<tr>
				<td class="name">생일</td>
				<td class="data"><input type="date" name="birthday" value="1990-01-01" min="1800-01-01" class="text"></td>
			</tr>
			
			<tr>
				<td class="name">성별</td>
				<td class="data">
					<input type="radio"  value="male" name="gender" ${member.gender==male? 'checked':'' }>남
					&nbsp&nbsp
					<input type="radio"  value="female" name="gender" ${member.gender==female? 'checked':'' }>여
				</td>
			</tr>			
			
			<tr>				
				<td class="name">전화번호</td>
				<td colspan="2" class="data"><input type="text" name="tel" value="${member.tel}"></td>
			</tr>			
			
			<tr>
				<td class="name">이메일</td>
				<td colspan="2" class="data"><input type="text" name="email"  value="${member.email}"></td>
			</tr>			
			
			<tr>
				<td class="button" colspan="3"  align="right"><input type="submit"   value="정보수정"></td>
			</tr>
		</table>
		
	</form>
</div>
</body>
</html>