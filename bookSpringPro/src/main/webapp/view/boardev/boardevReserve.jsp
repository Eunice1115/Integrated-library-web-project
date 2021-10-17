<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardevCss/boardevReserve.css">
</head>

<body>
<div id="box">
<section id="section">
<h3>행사예약확인내역</h3>
<table class="table">
	<tr class="tr1">
		<th>예약번호</th>
		<th>아이디</th>
		<th>종류</th>
		<th>제목</th>
		<th>도서관</th>
		<th>시작일</th>
	    <th>종료일</th>
	    <th>&nbsp</th>
	</tr>
	
	<c:forEach var="eventrsv" items="${list}">
	<tr class="tr1">
		<td>${eventrsv.rsvnum_ev }</td>
		<td>${eventrsv.memberid }</td>
		<c:if test="${eventrsv.boardid_ev eq '1'}">
		<td>지역행사</td>
		</c:if>
		<c:if test="${eventrsv.boardid_ev eq '2'}">
		<td>강연</td>
		</c:if>
		<c:if test="${eventrsv.boardid_ev eq '3'}">
		<td>체험프로그램</td>
		</c:if>
		<c:if test="${eventrsv.boardid_ev eq '4'}">
		<td>이벤트</td>
		</c:if>
		<td>${eventrsv.subject_ev }</td>
		<td>${eventrsv.library}</td>
		<td>${eventrsv.startdate}</td>
		<td>${eventrsv.lastdate}</td>
		
		<td><a href="<%=request.getContextPath() %>/boardev/evReserveDelete
		?eventnum=${eventrsv.eventnum }&memberid=${eventrsv.memberid }">[취소]</a></td>
	</tr>
	</c:forEach>
	
</table>

<br>

</section>
</div>


</body>
</html>