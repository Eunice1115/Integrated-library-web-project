<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>

<body>

<div id="box">


<form method="post" action="<%=request.getContextPath() %>/seat/seatInputPro" name="userInfo"
		id="form">
<h2>입실하기</h2>
		
<table class="table">

	<tr>
		<td> 좌석번호 :
		<input type="text" name="seatNum" maxlength="50" class="text">
		</td>
	</tr>
	
	<tr>
		<td>아이디 :
		<input type="text" name="memberid" maxlength="50" class="text" value='${memberid }'>
		</td>
	</tr>
	
	<tr>
		<td>비밀번호 :
		<input type="password" name="pass" maxlength="50" class="text">
		</td>
	</tr>
	
	<tr>
		<td>도서관명 :
		<div><input type="radio" name="library" value='논현도서관' checked>논현도서관</div>
		<div><input type="radio" name="library" value="강남도서관" >강남도서관</div>
		<div><input type="radio" name="library" value="대치도서관" >대치도서관</div>
		<div><input type="radio" name="library" value="삼성도서관" >삼성도서관</div>
		<div><input type="radio" name="library" value="역삼도서관" >역삼도서관</div>
		<div><input type="radio" name="library" value="열린도서관" >열린도서관</div>
		</td>
	</tr>
	<tr>
	
</table>
	<input type="submit" value="입실">
	<input type="submit" value="닫기" onclick="self.close()">
   
</form>

</div>
</body>
</html>