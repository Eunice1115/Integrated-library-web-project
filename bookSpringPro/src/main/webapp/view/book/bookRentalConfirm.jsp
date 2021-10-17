<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bookCss/bookRentalConfirm.css">
</head>

<body>
<div id="box">
<section id="section">
<h3>대출내역</h3>
<table class="table" >
	<tr class="tr1">
		<th>대출번호</th>
		<th>아이디</th>
		<th>책번호</th>
		<th>책이름</th>
		<th>작가</th>
		<th>도서관</th>
		<th>대출날짜</th>
		<th>반납예정날짜</th>
		<c:if test="${login eq 'admin' }">
		<th>&nbsp</th>
		</c:if>
		<th>&nbsp</th>
	</tr>
	
	<c:forEach var="join" items="${list}" >
	<tr class="tr1">
		<td>${join.rentalnum}</td>
		<td>${join.memberid }</td>
		<td>${join.booknum }</td>
		<td>${join.bookname }</td>
		<td>${join.author}</td>
		<td>${join.library}</td>
		<td>${join.rentaldate}</td>
		<td>${join.returndate_sch}</td>
		<c:if test="${login eq 'admin' }">
		<td><a href="<%=request.getContextPath() %>/book/bookReturn
		?memberid=${join.memberid}&booknum=${join.booknum}">[반납]</a></td>
		</c:if>
		<td><a href="<%=request.getContextPath()%>/book/bookReturnRenew
		?memberid=${join.memberid}&booknum=${join.booknum}">[연장]</a>
	</tr>
	</c:forEach>
</table>
</section>
</div>

</body>
</html>

