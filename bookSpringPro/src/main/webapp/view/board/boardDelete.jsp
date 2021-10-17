<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardCss/boardDelete.css">
</head>
<body>
<div  id="box">
	<%@include file = "../sidemenu/sidemenu1.jsp" %>
<form action="delete" name="f" method="post" class="form">
	<input type="hidden" name="num" value="${num}">
<h3>게시글 삭제</h3>

<table class="table">
	<tr>
		<td class="name">게시글 비밀번호</td>
		<td class="data"><input type="password" name="pass"></td>
	</tr>
	<tr>
		<td colspan="2" class="button"><input type="submit" value="글 삭제"></td>
	</tr>
</table>
</form>

</div>
</body>
</html>