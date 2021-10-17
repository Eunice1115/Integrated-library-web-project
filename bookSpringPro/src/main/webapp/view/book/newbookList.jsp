<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/bookCss/newbookList.css">

<script>
//검색창에 연도와 월을 입력하지 않았을 경우 실행
function check(){
	 if(form.req1.value == ""){
		 alert("연도를 입력하세요")
		 return false;
	 }
	 else if(form.req2.value == ""){
		 alert("월을입력하세요")
		 return false;
	 }else{
		 true;
	 }	 
}

</script>

</head>

<body>
<div id="box">
	<%@include file = "../sidemenu/sidemenu2.jsp" %>
<section id="section">
		
<h3>신착도서</h3>

<div id="searchForm" >
	<form action="<%=request.getContextPath() %>/book/newbooklist"  method="post"
	onsubmit = "return check()" id="form">
		<input type="text" name="req1" value="${req1 }"/>&nbsp년
		&nbsp
		<input type="text" name="req2" value="${req2 }"/>&nbsp월
		&nbsp&nbsp&nbsp<input type="submit" value="적용" />
	</form>
</div>


<table class="table">
	<tr class="tr1">
		<th width=10%>도서번호</th>
		<th width=10%>도서관</th>
		<th width=35%>제목</th>
		<th width=10%>저자</th>
		<th width=10%>출판사</th>
		<th width=10%>발행연도</th>
		<th width=15%>입고날짜</th>
	</tr>
	
	<c:forEach var="book" items="${list}">
	<tr class="tr1">
		<td>${book.booknum }</td>
		<td>${book.library }</td>
		<td>${book.bookname }</td>
		<td>${book.author }</td>
		<td>${book.publisher }</td>
		<td>${book.publicdate }</td>
		<td>${book.stockdate }</td>
	</tr>
	</c:forEach>
	
	<!-- 페이징 작업 -->
	<tr class="tr1">
		<td colspan="7">
			<c:if test="${startpage <= bottomLine}">
				<font color="grey"> [이전] </font>
			</c:if> 
			<c:if test="${startpage > bottomLine}">
				<a href="<%=request.getContextPath() %>/book/newbooklist
				?pageNum=${startpage - bottomLine}&req1=${req1}&req2=${req2}"><b>[이전]</b></a>
			</c:if> 
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
            <c:if test="${a==pageNum}">
				<font color="blue"> [${a}] </font>
			</c:if>
			<c:if test="${a!=pageNum}">
				<a href="<%=request.getContextPath() %>/book/newbooklist
				?pageNum=${a}&req1=${req1}&req2=${req2}"> [${a}]</a>
			</c:if>
			</c:forEach> 
			<c:if test="${endpage >= maxpage}">
				<font color="grey"> [다음] </font>
			</c:if> 
			<c:if test="${endpage < maxpage}">
				<a href="<%=request.getContextPath() %>/book/newbooklist?pageNum=${startpage + bottomLine}&req1=${req1}&req2=${req2}"><b>[다음]</b></a>
			</c:if>
		</td>		
	</tr>
</table>

</section>
</div>
</body>
</html>