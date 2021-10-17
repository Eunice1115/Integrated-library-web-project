<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardCss/boardList.css">
</head>

<body>
<div id="box">
	<%@include file = "../sidemenu/sidemenu1.jsp" %>
<section id="section">
		
<h3>${boardName }</h3>
			
<div id="searchForm" >
	<form action="<%=request.getContextPath() %>/board/list"  method="post">
	
	<select class="select">
		<option>도서관</option>
	</select>
	&nbsp<input type="text" name="req1"
	 placeholder="'논현', '대치', '삼성', '역삼', '청담', '세곡', '열린' 도서관이 있습니다." value="${req1 }"/>
	
	<br>
	<select class="select">
		<option>제목</option>
	</select>
	&nbsp<input type="text" name="req2" value="${req2 }"/>
	&nbsp&nbsp&nbsp<input type="submit" value="적용"/>
	</form>
</div>
			
<table class="table">
	<tr class="tr1">
		<td colspan="7" >글개수:${boardcount}</td>	 
	</tr>
	<tr class="tr2">
		<th>번호</th>
		<th>도서관</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>파일</th>
	</tr>
		
	<c:forEach var="board" items="${list}" >
	<tr class="tr2">
		<td>${boardnum}</td>
		<c:set var="boardnum" value="${boardnum-1 }" />
		<td>${board.library }</td>
		<td>
		<c:if test="${board.reflevel > 0 }">
			<img src="<%=request.getContextPath() %>/img/level.gif"  width="${5*board.reflevel}px">
			<img src="<%=request.getContextPath() %>/img/re.gif"  >
		</c:if>
			<a href="info?num=${board.num}">${board.subject}</a>
		</td>
		<td>${board.memberid}</td>
		<td>${board.regdate}</td>
		<td>${board.readcnt}</td>
		<td>
		<c:if test="${board.file1 != null && board.file1.trim() ne '' }">
		<a href="<%=request.getContextPath() %>/upfile/${board.file1}"> ${board.file1}</a>
		</c:if> &nbsp;</td>
		</tr>
	</c:forEach>

	<!-- 페이징 작업 -->
	<tr class="tr3">
		<td colspan="6">
		<c:if test="${startpage <= bottomLine}">
			<font color="grey"> [이전] </font>
		</c:if>
		<c:if test="${startpage > bottomLine}">
			<a href="<%=request.getContextPath() %>/board/list?pageNum=${startpage - bottomLine}&req1=${req1}&req2=${req2}"><b>[이전]</b></a>
		</c:if> 
			<c:forEach var="a" begin="${startpage}" end="${endpage}">
		<c:if test="${a==pageNum}">
			<font color="blue"> [${a}] </font>
		</c:if>
		<c:if test="${a!=pageNum}">
			<a href="<%=request.getContextPath() %>/board/list
			?pageNum=${a}&req1=${req1}&req2=${req2}"> [${a}]</a>
		</c:if>
		</c:forEach> 
		<c:if test="${endpage >= maxpage}">
		<font color="grey"> [다음] </font>
		</c:if> <c:if test="${endpage < maxpage}">
			<a href="<%=request.getContextPath() %>/board/list
			?pageNum=${startpage + bottomLine}&req1=${req1}&req2=${req2}"><b>[다음]</b></a>
		</c:if>
		</td>
					
		<c:if test="${login eq 'admin' and boardid eq '1' }">
		<td><a href="<%=request.getContextPath() %>/board/writeForm">[글쓰기]</a></td>
		</c:if>
		<c:if test="${login ne 'admin' and login!=null and boardid eq '2' }">
		<td><a href="<%=request.getContextPath() %>/board/writeForm">[글쓰기]</a></td>
		</c:if>
	</tr>
			
</table>
		
</section>
</div>
	
</body>
</html>