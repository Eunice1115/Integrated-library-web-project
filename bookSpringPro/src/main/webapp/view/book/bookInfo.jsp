<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bookCss/bookInfo.css">
</head>

<body>

<div id="box">
	<%@include file = "../sidemenu/sidemenu2.jsp" %>
<section id="section">
		
<h3>도서정보</h3>

	<table class="table">
		<tr class="tr1">
			<td rowspan="7" class="td1">
				<img src="<%=request.getContextPath() %>/photo/${book.bookpicture}" id="pic">
			</td>
			<th>책 번호 :</th>
			<td>${book.booknum }</td>
		</tr>
		<tr class="tr1">
			<th>제목 :</th>
			<td>${book.bookname}</td>
		</tr>
		<tr class="tr1">
			<th>작가 :</th>
			<td>${book.author }</td>
		</tr>
		<tr class="tr1">
			<th>출판사 :</th>
			<td>${book.publisher}</td>
		</tr>
		<tr class="tr1">
			<th>출판날짜 :</th>
			<td>${book.publicdate }&nbsp년</td>
		</tr>
		<tr class="tr1">
			<th>도서관 :</th>
			<td>${book.library}</td>
		</tr>
		<tr class="tr1">
			<th>도서상태 :</th>
			<td>${book.bookstate }</td>
		</tr>
		<c:if test="${login != null }">
		<tr class="tr2">
			<td colspan="3">
				<c:if test="${login eq 'admin' }">
				<br>
				<a href="bookUpdateForm?booknum=${book.booknum }">[수정]</a>
				<a href="bookDelete?booknum=${book.booknum}">[삭제]</a>
				<br>
				</c:if>
				<form action="<%=request.getContextPath() %>/book/bookReservePro" method="post">
				<input type="hidden" name="memberid" value="${login }">
				<input type="hidden" name="booknum" value="${book.booknum }">
				<input type="hidden" name="bookname" value="${book.bookname }">
				<input type="hidden" name="library" value="${book.library }">
				<input type="hidden" name="author" value="${book.author }">
				<input type="submit" value="예약">
				</form>
				<br>
			</td>
		</tr>
		</c:if>
	
	</table>
	
	<br>
	<table class="table2">
		<tr class="tr3">
		  <th>책번호</th>
		  <th>도서상태</th>
		  <th>도서관</th>
		  <th>반납예정일</th>
		  <th>예약인원</th>
		</tr>
		
		<tr class="tr3">
		  <td>${book.booknum }</td>
		  <td>${book.bookstate }</td>
		  <td>${book.library}</td>
		  <td>${rental.returndate_sch }</td>
		  <td>${num}</td>
	</table>
	
	<br>
	<input type="button" value="목록" onClick="location.href='<%=request.getContextPath() %>/book/booklist'">

</section>
</div>

</body>
</html>