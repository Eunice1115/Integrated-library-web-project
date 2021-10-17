<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardevCss/boardevUpdate.css">
<script>
//파일 업로드시 사진을 바로 보여주는 기능
	function PreviewImage(){
		var preview = new FileReader();
		preview.onload = function(e){
			document.getElementById("pic").src = e.target.result;
		};
		preview.readAsDataURL(document.getElementById("img").files[0]);
	};
</script>
</head>
<body>

<div id="box">
	<%@include file = "../sidemenu/sidemenu3.jsp" %> 
<section id="section">

<h3>${boardName} 수정</h3>

<form action="<%=request.getContextPath() %>/boardev/evUpdatePro" method="post" enctype="multipart/form-data"
		name="f">
	<input type="hidden" name="eventnum" value="${ boardev.eventnum}">
	<input type="hidden" name="content_ev" value="${boardev.content_ev}"/>
	<input type="hidden" name="boardid_ev" value="${boardev.boardid_ev }">
	<input type="hidden" name="register" value="${boardev.register }">
	
		
			
<table class="table">
	<tr class="tr1">
		<th colspan="2"> 제목</th>
		<td colspan ="6"><input type="text" name="subject_ev" value="${boardev.subject_ev}"></td>
	</tr>
	<tr class="tr2">
		<th>도서관</th>
		<td>
			<select class="select" name="library">
				<option value="논현" <c:if test="${boardev.library == '논현' }">selected</c:if>>논현도서관</option>
				<option value="대치" <c:if test="${boardev.library == '대치' }">selected</c:if>>대치도서관</option>
				<option value="삼성" <c:if test="${boardev.library == '삼성' }">selected</c:if>>삼성도서관</option>
				<option value="역삼" <c:if test="${boardev.library == '역삼' }">selected</c:if>>역삼도서관</option>
				<option value="청담" <c:if test="${boardev.library == '청담' }">selected</c:if>>청담도서관</option>
				<option value="세곡" <c:if test="${boardev.library == '세곡' }">selected</c:if>>세곡도서관</option>
				<option value="열린" <c:if test="${boardev.library == '논현' }">selected</c:if>>열린도서관</option>
			</select>
		</td>
		        
		<th>작성자</th>
		<td><input type="text" name="memberid" value="${login}"></td>
		<th>비밀번호</th>
		<td width=15%><input type="password" name="pass"></td>
		<th>상태</th>
		<td>
			<select class="select" name="state">
				<option value="접수중" <c:if test="${boardev.state == '접수중' }">selected</c:if>>접수중</option>
				<option value="접수종료" <c:if test="${boardev.state == '접수종료' }">selected</c:if>>접수종료</option>
			</select>
		</td>
	</tr>	
			
	<tr class="tr2">
		<th>시작일</th><td><input type="date" name="startdate" value="${boardev.startdate }"></td>
		<th>종료일</th><td><input type="date" name="lastdate" value="${boardev.lastdate }"></td>
		<th>정원</th><td><input type="text" name="total" value="${boardev.total }">&nbsp명</td>
		<th>대상</th>
		<td>
			<select class="select" name="target">
			     <option value="유아" <c:if test="${boardev.target == '유아' }">selected</c:if>>유아</option>
			     <option value="초등" <c:if test="${boardev.target == '초등' }">selected</c:if>>초등</option>
			     <option value="중등" <c:if test="${boardev.target == '중등' }">selected</c:if>>중등</option>
			     <option value="고등" <c:if test="${boardev.target == '고등' }">selected</c:if>>고등</option>
			     <option value="일반" <c:if test="${boardev.target == '일반' }">selected</c:if>>일반</option>
			</select>
		</td>
	</tr>
			
	<tr class="tr3">
		<th colspan ="8">내용</th>
	</tr>
			
	<tr class="tr1">
		<td colspan="8" height=auto><img src="<%=request.getContextPath() %>/photo/${boardev.content_ev}" id="pic">
		<tr class="tr5">
		<td colspan="8" >
		<input type="file" id="img" accept="image/*" name="f" onchange="PreviewImage();"/>
		<td>
	</tr>
</table>
	<input type="submit"   value="수정">
</form>

</section>
</div>

	
</body>
</html>