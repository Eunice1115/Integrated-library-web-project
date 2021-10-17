<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardCss/boardInfoForm.css">
<script>
//공지사항 폼 화면에 데이터가 다 채워지지 않을 경우 실행
	function board_submit() {
		var f = document.f;
		if (f.subject.value == "") {
			alert("제목을 입력하세요") 
			f.name.focus()
			return
		}
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

<h3>${boardName} 작성</h3>

<form action="<%=request.getContextPath() %>/board/writePro" method="post" enctype="multipart/form-data"
		name="f">
		
<table class="table">
	<tr class="tr1">
		<th colspan="2"> 제목</th>
		<td colspan ="6"><input type="text" name="subject"></td>
	</tr>
	<tr class="tr2">
		<th width=7%>도서관</th>
		<td width=15%>
		<select class="select" name="library">
			<option value="논현도서관">논현도서관</option>
			<option value="대치도서관">대치도서관</option>
			<option value="삼성도서관">삼성도서관</option>
			<option value="역삼도서관">역삼도서관</option>
			<option value="청담도서관">청담도서관</option>
			<option value="세곡도서관">세곡도서관</option>
			<option value="열린도서관">열린도서관</option>
		</select>
		</td>
		<th width=7%>작성자</th>
		<td width=18%><input type="text" name="memberid" value=${login }></td>
		<th width=9%>비밀번호</th>
		<td width=24%><input type="password" name="pass"></td>
	</tr>	
	<tr class="tr3">
		<th colspan ="8">내용</th>
	</tr>
	<tr>
		<td colspan ="8" class="tr4">
		<textarea  colums="8" rows="15" name="content"></textarea>
		</td>
	</tr>
	<tr class="tr1">
		<th colspan="2">첨부파일</th>
		<td colspan="6"><input type="file" name="f"></td>
	</tr>
	<tr class="tr5">
		<td colspan="8"><a href="javascript:board_submit()">[게시물등록]</a></td>
	</tr>
</table>
</form>
</section>
</div>

	
</body>
</html>