<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/seatCss/seatList.css">
</head>

<body>
<div id="box">
<section id="section">

<h3>시설예약내역</h3>

<table class="table" >
	<tr class="tr1">
		<th>좌석번호</th>
		<th>아이디</th>
		<th>도서관</th>
		<th>입실시간</th>
		<th>퇴실시간</th>
	</tr>
	<c:forEach var="seat" items="${list}" >
	<tr class="tr1">
		<td>${seat.seatNum}</td>
		<td>${seat.memberid }</td>
		<td>${seat.library}</td>
		<td>${seat.checkIn }</td>
		<td>${seat.checkOut}</td>
	</tr>
	</c:forEach>
</table>

</section>
</div>

</body>
</html>

