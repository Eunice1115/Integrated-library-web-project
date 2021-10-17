<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardCss/replyForm.css">

<script>
//답변 폼에 데이터를 입력하지 않았을 경우 실행
	function board_submit() {
		var f = document.f;
		if (f.name.value == "") {
			alert("이름을 입력하세요") 
			f.name.focus()
			return
		}
		if (f.pass.value == "") {
			alert("비밀번호를 입력하세요")
			f.pass.focus();
			return;
		}
		if (f.subject.value == "") {
			alert("제목을 입력하세요")
			f.subject.focus();
			return;
		}
		if (f.content.value == "") {
			alert("내용을 입력하세요")
			f.content.focus();
			return;
		}
		f.submit();
	}
</script>
</head>

<body>
<div id="box">
	<%@include file = "../sidemenu/sidemenu1.jsp" %>
<section id="section">

<h3>${boardName} : 답글쓰기</h3>
<form action="replyPro" method="post"  	name="f">
	<input type="hidden"  name="num" value="${board.num}">
	<input type="hidden"  name="ref" value="${board.ref}">
	<input type="hidden"  name="refstep" value="${board.refstep}">
	<input type="hidden"  name="reflevel" value="${board.reflevel}">
	<input type="hidden"  name="library" value="${board.library}">	
<table class="table">
	<tr class="tr1">
		<th width=15%>작성자</th>
		<td><input type="text" name="memberid" value=${login }></td>
		<th width=20%>비밀번호</th>
		<td><input type="password" name="pass"></td>
	</tr>
	<tr class="tr1">
		<th>도서관</th>
		<td>${board.library }
		<th>제목
		<td><input type="text" name="subject" value="re:${board.subject}"> </td>
	</tr>
				
	<tr class="tr1">
		<th>내용</th>
		<td colspan="3"><textarea rows="15" name="content"></textarea></td>
	</tr>
	<tr class="tr2">
		<td colspan="4"><a href="javascript:board_submit()">[답글등록]</a></td>
	</tr>
</table>
		
</form>
</section>
</div>
</body>
</html>