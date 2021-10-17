<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bookCss/bookUpdate.css">

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

<form action="<%=request.getContextPath() %>/book/bookUpdatePro" name="f" method="post" id="form"
enctype="multipart/form-data">
	<input type="hidden" name="bookpicture" value="${book.bookpicture}">
	<table class="table">
		<tr class="tr1">
			<td rowspan="9" class="td1">
				<img src="<%=request.getContextPath() %>/photo/${book.bookpicture}" id="pic">
				<input type="file" name="f" accept="image/*" name="f" onchange="PreviewImage();" id="img" >
			</td>
			<th>책 번호</th>
			<td><input type="text" name="booknum" value="${book.booknum }"></td>
		</tr>
		<tr class="tr1">
			<th>제목</th>
			<td><input type="text" name="bookname" value="${book.bookname }"></td>
		</tr>
		<tr class="tr1">
			<th>작가</th>
			<td><input type="text" name="author" value="${book.author}"></td>
		</tr>
		<tr class="tr1">
			<th>출판사</th>
			<td><input type="text" name="publisher" value="${book.publisher}"></td>
		</tr>
		<tr class="tr1">
			<th>출판날짜</th>
			<td><input type="text" name=publicdate value="${book.publicdate }">&nbsp년</td>
		</tr>
		<tr class="tr1">
			<th>입고날짜</th>
			<td><input type="date" name="stockdate" min="2016-09-01" 
			    value="${book.stockdate }"></td>
		</tr>
		<tr class="tr1">
			<th>도서관</th>
			<td>
				<select class="select" name="library" >
					<option value="논현" <c:if test="${book.library == '논현' }">selected</c:if>>논현도서관</option>
					<option value="대치" <c:if test="${book.library == '대치' }">selected</c:if>>대치도서관</option>
					<option value="삼성" <c:if test="${book.library == '삼성' }">selected</c:if>>삼성도서관</option>
					<option value="역삼" <c:if test="${book.library == '역삼' }">selected</c:if>>역삼도서관</option>
					<option value="청담" <c:if test="${book.library == '청담' }">selected</c:if>>청담도서관</option>
					<option value="세곡" <c:if test="${book.library == '세곡' }">selected</c:if>>세곡도서관</option>
					<option value="열린" <c:if test="${book.library == '열린' }">selected</c:if>>열린도서관</option>
				</select>
			</td>
		</tr>
		<tr class="tr1">
			<th>도서상태</th>
			<td>
				<select class="select" name="bookstate" >
					<option value="대출가능" <c:if test="${book.bookstate == '대출가능' }">selected</c:if>>대출가능</option>
					<option value="대출중" <c:if test="${book.library == '대출중' }">selected</c:if>>대출중</option>
				</select>
			</td>
		</tr>
	</table>
	
	<input type="submit"   value="수정">
</form>
</section>
</div>




</body>

</html>