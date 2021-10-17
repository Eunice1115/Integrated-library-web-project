<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bookCss/bestbookList.css">
</head>

<body>
<div id="box">
	<%@include file = "../sidemenu/sidemenu2.jsp" %>
<section id="section">
		
<h3>인기도서 (Top 10)</h3>
<table class="table">
	<tr class="tr1">
		<th width=10%>순위</th>
		<th width=60%>제목</th>
		<th width=15%>작가</th>
		<th width=15%>대여횟수</th>
	</tr>
	
	<c:forEach var="bestbook" items="${list}" begin="0" end="9">
	<tr class="tr1">
		<td>${bestbook.rank }</td>
		<td>${bestbook.bookname }</td>
		<td>${bestbook.author }</td>
		<td>${bestbook.borrowcount }</td>
	</tr>
	</c:forEach>
</table>

</section>
</div>

</body>
</html>