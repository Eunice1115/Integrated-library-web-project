<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html><html><head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardCss/boardUpdate.css">

<script>
//첨부파일을 삭제하는 기능
	function file_delete() {
		file_desc = document.getElementById("file_desc")
		document.f.file1.value = "";
		file_desc.style.display = "none";
	}
</script>
</head>

<body>
<div id="box">
	<%@include file = "../sidemenu/sidemenu1.jsp" %>
<section id="section">
<h3>수정</h3>

<form action="update" method="post" enctype="multipart/form-data"
		name="f">
	<input type="hidden" name="num" value="${board.num}">
	<input type="hidden" name="file1"  	value="${board.file1}">
		
<table class="table">
	<tr class="tr1">
		<th>작성자</th>
		<td><input type="text" name="memberid" value="${login}"></td>
		<th>비밀번호</th>
			<td><input type="password" name="pass"></td>
	</tr>
	<tr class="tr1">
		<th>제목</th>
		<td colspan="3"><input type="text" name="subject" value="${board.subject}"></td>
	</tr>
	<tr class="tr1">
		<th>내용</th>
		<td colspan="3"><textarea rows="15" name="content">${board.content}</textarea></td>
	</tr>
	<tr class="tr1">
		<th>첨부파일</th>
		<td colspan="3">
		<c:if test="${board.file1 != null && board.file1 ne ''}">
		<div id="file_desc">${board.file1}
			<a href="javascript:file_delete()">[첨부파일 삭제]</a>
		</div> 
		</c:if>
		<input type="file" name="f" accept="image/*" onchange="PreviewImage();">
		</td>
	</tr>
	<tr class="tr2">
		<td colspan="4"><a href="javascript:document.f.submit()">[게시물수정]</a></td>
	</tr>
</table>

</form>
	
</section>
</div>
</body>
</html>