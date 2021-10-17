<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardCss/boardInfo.css">
</head>

<body>

<div id="box">
	<%@include file = "../sidemenu/sidemenu1.jsp" %> 
		
<section id="section">
<h3>${boardName}</h3>
		
<table class="table">
	<tr class="tr1">
		<th colspan="2"> 제목</th>
		<td colspan="6">${board.subject}</td>
	</tr>
	<tr class="tr2">
		<th width=7%>도서관</th>
		<td width=20%>${board.library }</td>
		<th width=7%>작성자</th>
		<td width=12%>${board.memberid }</td>
		<th width=9%>작성일자</th>
		<td width=26%>${board.regdate }</td>
		<th width=7%>조회수</th>
		<td>${board.readcnt }</td>		
	</tr>	
	<tr class="tr3">
		<th colspan ="8">내용</th>
	</tr>
	<tr class="tr4"><td colspan ="8">${board.content}</td></tr>
	<tr class="tr1">
		<th colspan ="2">첨부파일</th>
		<td colspan ="6"><img src="<%=request.getContextPath() %>/upfile/${board.file1}" width="200px"></td>
	</tr>
	
	
	<c:if test="${login != null }">
	<tr class="tr5">
		<td colspan="8">
		<a href="replyForm?num=${board.num}">[답변]</a> 
		<c:if test="${login eq board.memberid}"> <%--글 작성자만 수정,삭제 가능 --%>
		<a href="updateForm?num=${board.num}">[수정]</a> 
		<a href="deleteForm?num=${board.num}">[삭제]</a> 
		</c:if>
		</td>
	</tr>
	</c:if>
	
			
	<tr class="tr5">
		<td colspan="8" align="center" >
		<a href="list">[목록]</a>
		</td>
	</tr>
</table>
		
</section>
	
</div>
	
</body>
</html>