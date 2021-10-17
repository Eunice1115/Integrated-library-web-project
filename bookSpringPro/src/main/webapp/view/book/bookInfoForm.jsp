<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bookCss/bookInfoForm.css">

<script>
//파일을 업로드하면 바로 이미지로 보여주는 기능
	function PreviewImage(){
		var preview = new FileReader();
		preview.onload = function(e){
			document.getElementById("pic").src = e.target.result;
		};
		preview.readAsDataURL(document.getElementById("img").files[0]);
	};
</script>

</head>

<body>

<div id="box">
	<%@include file = "../sidemenu/sidemenu2.jsp" %>
<section id="section">
		
<h3>도서등록</h3>

<form action="<%=request.getContextPath() %>/book/bookInfoPro" name="f" method="post" id="form"
enctype="multipart/form-data">

	<input type="hidden" name="bookpicture" value="">
	
	<table class="table">
		<tr class="tr1">
			<td rowspan="9" class="td1">
				<img src="#" id="pic"><br>
				<input type="file" id="img" accept="image/*" name="f" onchange="PreviewImage();"/>
			</td>
			<th>책 번호</th>
			<td><input type="text" name="booknum"></td>
		</tr>
		<tr class="tr1">
			<th>제목</th>
			<td><input type="text" name="bookname"></td>
		</tr>
		<tr class="tr1">
			<th>작가</th>
			<td><input type="text" name="author"></td>
		</tr>
		<tr class="tr1">
			<th>출판사</th>
			<td><input type="text" name="publisher"></td>
		</tr>
		<tr class="tr1">
			<th>출판날짜</th>
			<td><input type="text" name=publicdate>&nbsp년</td>
		</tr>
		<tr class="tr1">
			<th>입고날짜</th>
			<td><input type="date" name="stockdate" value="2021-09-01" min="2016-09-01"></td>
		</tr>
		<tr class="tr1">
			<th>도서관</th>
			<td>
				<select class="select" name="library">
					<option value="논현">논현도서관</option>
					<option value="대치">대치도서관</option>
					<option value="삼성">삼성도서관</option>
					<option value="역삼">역삼도서관</option>
					<option value="청담">청담도서관</option>
					<option value="세곡">세곡도서관</option>
					<option value="열린">열린도서관</option>
				</select>
			</td>
		</tr>
		<tr class="tr1">
			<th>도서상태</th>
			<td>
				<select class="select" name="bookstate">
					<option value="대출가능">대출가능</option>
					<option value="대출중">대출중</option>
				</select>
			</td>
		</tr>
	</table>
	
	<input type="submit"   value="등록">
</form>

</section>
</div>

</body>

</html>