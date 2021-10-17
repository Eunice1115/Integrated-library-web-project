<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 목록보기</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardevCss/boardevList.css">
</head>

<body>
<div id="box">
	<%@include file = "../sidemenu/sidemenu3.jsp" %>
<section id="section">
		
<h3>${boardName }</h3>
			
	<div id="searchForm" >
	<form action="<%=request.getContextPath() %>/boardev/evlist"  method="post">
		<select class="select">
			<option>도서관</option>
		</select>
		&nbsp<input type="text" name="req1" placeholder="'논현', '대치', '삼성', '역삼', '청담', '세곡', '열린' 도서관이 있습니다." value="${req1}" }/>
		<br>
		<select class="select">
			<option>대상</option>
		</select>
		&nbsp<input type="text" name="req2" placeholder="'유아', '초등', '중등', '고등', '일반' 중 하나를 입력하세요." value="${req2 }"/>
		&nbsp&nbsp&nbsp<input type="submit" value="적용"  />
	</form>
    </div>
			
<table class="table">
	<tr class="tr2">
		<th>도서관</th>
		<th>대상</th>
		<th>제목</th>
		<th>시작일</th>
		<th>종료일</th>
		<th>신청인원</th>
		<th>정원</th>
		<th>상태</th>
	</tr>
	<c:forEach var="boardev" items="${list}">
	<tr class="tr2">
		<td>${boardev.library}</td>
		<td>${boardev.target}</td>
		<td><a href="evChk?eventnum=${boardev.eventnum}">${boardev.subject_ev}</a></td>
		<td>${boardev.startdate}</td>
		<td>${boardev.lastdate}</td>
		<td>${boardev.register}</td>
		<td>${boardev.total}</td>
		<td>${boardev.state}</td>
	</tr>
	</c:forEach>
	
	<!-- 페이징 작업 -->
	<tr class="tr3">
		<td colspan="7">
		<c:if test="${startpage <= bottomLine}">
			<font color="grey"> [이전] </font>
		</c:if> 
		<c:if test="${startpage > bottomLine}">
			<a href="<%=request.getContextPath() %>/boardev/evlist
			?pageNum=${startpage - bottomLine}&req1=${req1}&req2=${req2}"><b>[이전]</b></a>
		</c:if> 
		<c:forEach var="a" begin="${startpage}" end="${endpage}">
		<c:if test="${a==pageNum}">
			<font color="blue"> [${a}] </font>
		</c:if>
		<c:if test="${a!=pageNum}">
			<a href="<%=request.getContextPath() %>/boardev/evlist
			?pageNum=${a}&req1=${req1}&req2=${req2}"> [${a}]</a>
		</c:if>
		</c:forEach> 
		<c:if test="${endpage >= maxpage}">
			<font color="grey"> [다음] </font>
		</c:if> <c:if test="${endpage < maxpage}">
			<a href="<%=request.getContextPath() %>/boardev/evlist
				?pageNum=${startpage + bottomLine}&req1=${req1}&req2=${req2}"><b>[다음]</b></a>
		</c:if>
		</td>
					
		<c:if test="${login eq 'admin'}">
		<td><a href="<%=request.getContextPath() %>/boardev/evWriteForm">[글쓰기]</a></td>
		</c:if>
	</tr>
			
</table>
		
</section>
</div>
	
</body>
</html>