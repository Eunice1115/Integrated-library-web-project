<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bookCss/bookList.css">
</head>

<body>
<div id="box">
	<%@include file = "../sidemenu/sidemenu2.jsp" %>
<section id="section">
		
<h3>도서검색</h3>

<div id="searchForm" >
	<form action="<%=request.getContextPath() %>/book/booklist"  method="post">
		<select class="select">
			<option>도서관</option>
		</select>
		&nbsp<input type="text" name="req1" placeholder="'논현', '대치', '삼성', '역삼', '청담', '세곡', '열린' 도서관이 있습니다." value="${req1 }" />
		<br>
		<select class="select">
			<option>제목</option>
		</select>
		&nbsp<input type="text" name="req2" value="${req2 }"/>
		<br>
		<select class="select">
			<option>저자</option>
		</select>
		&nbsp<input type="text" name="req3" value="${req3 }"/>
		&nbsp&nbsp&nbsp<input type="submit" value="적용"/>
	</form>
</div>

<table class='table'>
	<tr class="tr2">
		<td colspan="7"  align=right>책개수:${bookcount}</td>	 
	</tr>
	<tr class="tr1">
		<th width=10%>도서번호</th>
		<th width=10%>도서관</th>
		<th width=40%>제목</th>
		<th width=10%>저자</th>
		<th width=10%>출판사</th>
		<th width=10%>발행연도</th>
		<th width=10%>상태</th>
	</tr>
	<c:forEach var="book" items="${list}">
	<tr class="tr1">
		<td >${book.booknum}</td>
		<td>${book.library}</td>
		<td><a href="bookInfo?booknum=${book.booknum}">${book.bookname}</a></td>
		<td>${book.author}</td>
		<td>${book.publisher}</td>
		<td>${book.publicdate}</td>
		<td>${book.bookstate}</td>
	</tr>
	</c:forEach>
	<!-- 페이징 작업 -->
	<tr class="tr1">
		<td colspan="7">
			<c:if test="${startpage <= bottomLine}">
				<font color="grey"> [이전] </font>
			</c:if> 
			<c:if test="${startpage > bottomLine}">
				<a href="<%=request.getContextPath() %>/book/booklist
				?pageNum=${startpage - bottomLine}&req1=${req1}&req2=${req2}&req3=${req3}"><b>[이전]</b></a>
			</c:if> 
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
            <c:if test="${a==pageNum}">
				<font color="blue"> [${a}] </font>
			</c:if>
			<c:if test="${a!=pageNum}">
				<a href="<%=request.getContextPath() %>/book/booklist
				?pageNum=${a}&req1=${req1}&req2=${req2}&req3=${req3}"> [${a}]</a>
			</c:if>	
			</c:forEach> 
			<c:if test="${endpage >= maxpage}">
				<font color="grey"> [다음] </font>
			</c:if> 
			<c:if test="${endpage < maxpage}">
				<a href="<%=request.getContextPath() %>/book/booklist
				?pageNum=${startpage + bottomLine}&req1=${req1}&req2=${req2}&req3=${req3}"><b>[다음]</b></a>
			</c:if>
		</td>
					
	</tr>
			
	<c:if test="${login eq 'admin' }">
	<tr class="tr2">
		<td colspan=7 align="right"><a href="<%=request.getContextPath() %>/book/bookInfoForm">[책 등록]</a></td>
	</tr>
	</c:if>
</table>

</section>
</div>

</body>
</html>