<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bookCss/bookReserveConfirm.css">
</head>

<body>
<div id="box">
<section id="section">
<h3>도서예약확인내역</h3>
<table class="table">
	<tr class="tr1">
		<th>예약번호</th>
		<th>아이디</th>
		<th>책 이름</th>
		<th>저자</th>
		<th>도서관</th>
		<th>예약날짜</th>
	    <th>&nbsp</th>
	</tr>
	
	<c:forEach var="brsv" items="${list}">
	<tr class="tr1">
		<td>${brsv.rsvnum }</td>
		<td>${brsv.memberid }</td>
		<td>${brsv.bookname}</td>
		<td>${brsv.author}</td>
		<td>${brsv.library}</td>
		<td>${brsv.rsvdate}</td>
		<td><a href="<%=request.getContextPath() %>/book/bookReserveDelete
		?booknum=${brsv.booknum }&memberid=${brsv.memberid }">[취소]</a></td>
	</tr>
	</c:forEach>
</table>

<br>

</section>
</div>

</body>
</html>