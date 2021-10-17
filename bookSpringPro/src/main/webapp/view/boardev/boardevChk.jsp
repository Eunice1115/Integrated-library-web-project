<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardevCss/boardevChk.css">
</head>

<body>

<div id="box">
	<%@include file = "../sidemenu/sidemenu3.jsp" %> 
<section id="section">

<h3>${boardName}</h3>
	<table class="table">
		<tr class="tr1">
			<th colspan="2"> 제목</th>
			<td colspan ="6">${boardev.subject_ev} </td>
		</tr>
		<tr class="tr2">
			<th>도서관</th>
			<td>${boardev.library} </td>
		    <th>작성자</th>
			<td>${boardev.memberid} </td>
			<th>상태</th>
			<td>${boardev.state} </td>
		</tr>	
		<tr class="tr2">
			<th>시작일</th><td>${boardev.startdate} </td>
			<th>종료일</th><td>${boardev.lastdate} </td>
			<th>정원</th><td>${boardev.total} &nbsp명</td>
			<th>대상</th><td>${boardev.target} </td>
		</tr>
		<tr class="tr3">
			<th colspan ="8">내용</th>
		</tr>
		<tr class="tr1">
			<td colspan="8" height=auto><img src="<%=request.getContextPath() %>/photo/${boardev.content_ev}" id="pic">
		</tr>
		<c:if test="${login != null }">
		<tr class="tr5">
			<td colspan="8">
			<c:if test="${login eq 'admin'}">
			<br>
			<a href="evUpdateForm?eventnum=${boardev.eventnum }">[게시물수정]</a>&nbsp&nbsp
			<a href="evDeleteForm?eventnum=${boardev.eventnum }">[게시물삭제]</a>
			<br>
			</c:if>
			<form action="evReserve" method="post">
			<input type="hidden" name="eventnum" value="${boardev.eventnum }">
			<input type="hidden" name="memberid" value="${login }">
			<input type="hidden" name="boardid_ev" value="${boardev.boardid_ev}">
			<input type="hidden" name="subject_ev" value="${boardev.subject_ev}">
			<input type="hidden" name="library" value="${boardev.library}">
			<input type="hidden" name="startdate" value="${boardev.startdate}">
			<input type="hidden" name="lastdate" value="${boardev.lastdate}">
			<input type="submit" value="예약">
	        </form>
		    <br>
			</td>
		</tr>
		</c:if>
	</table>
		
	<c:if test="${login eq 'admin'}">
	<br>
	<br>
		
	<h2>----------------------   신청현황   ----------------------</h2>
	<table class="table2">
		<tr class="tr3">
		  <th>도서관</th>
		  <th>신청번호</th>
		  <th>아이디</th>
		  <th>행사이름</th>
		</tr>
		
		<c:forEach var="eventrsv" items="${list}">
		<tr class="tr3">
		  <td>${eventrsv.library }</td>
		  <td>${eventrsv.rsvnum_ev }</td>
		  <td>${eventrsv.memberid}</td>
		  <td>${eventrsv.subject_ev}</td>
		 </tr>
		 </c:forEach>
	 </table>
	 </c:if>
	     
	
	<input type="button" value="목록" onClick="location.href='<%=request.getContextPath() %>/boardev/evlist'">
		
</section>
</div>

</body>
</html>