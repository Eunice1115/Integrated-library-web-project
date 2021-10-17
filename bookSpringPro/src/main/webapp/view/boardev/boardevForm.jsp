<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardevCss/boardevForm.css">
</head>

<script>
//이벤트 폼 데이터를 채우지 않았을 경우 실행
	function board_submit() {
		var f = document.f;
		if (f.subject_ev.value == "") {
			alert("제목을 입력하세요") 
			f.subject_ev.focus()
			return
		}
		if (f.pass.value == "") {
			alert("비밀번호를 입력하세요")
			f.pass.focus();
			return;
		}
		if (f.total.value == "") {
			alert("정원을 입력하세요")
			f.total.focus();
			return;
		}
		
		f.submit();
	}

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

<h3>${boardName} 작성</h3>

<form action="<%=request.getContextPath() %>/boardev/evWritePro" method="post" enctype="multipart/form-data"
		name="f">
	<input type="hidden" name="content_ev" value=""/>
	
	<table class="table">
		<tr class="tr1">
			<th colspan="2"> 제목</th>
			<td colspan ="6"><input type="text" name="subject_ev"></td>
		</tr>
		<tr class="tr2">
			<th>도서관</th>
			<td>
				<select class="select" name="library">
					<option value="논현">논현도서관</option>
					<option value="대치">대치도서관</option>
					<option value="삼성">삼성도서관</option>
					<option value="역삼">역삼도서관</option>
					<option value="청담">청담도서관</option>
					<option value="세곡">세곡도서관</option>
					<option value="열린">열린도서관</option>
				</select>
		    </td>
		    <th>작성자</th>
			<td><input type="text" name="memberid" value=${login }></td>
			<th>비밀번호</th>
			<td width=15%><input type="password" name="pass"></td>
			<th>상태</th>
			<td>
				<select class="select" name="state">
				      <option value="접수중">접수중</option>
				</select>
			</td>
			</tr>	
			<tr class="tr2">
			  <th>시작일</th><td><input type="date" name="startdate"></td>
			  <th>종료일</th><td><input type="date" name="lastdate"></td>
			  <th>정원</th><td><input type="text" name="total">&nbsp명</td>
			  <th>대상</th>
			  <td>
			     <select class="select" name="target">
			        <option value="유아">유아</option>
			        <option value="초등">초등</option>
			        <option value="중등">중등</option>
			        <option value="고등">고등</option>
			        <option value="일반">일반</option>
			     </select>
			  </td>
			</tr>
			<tr class="tr3">
				<th colspan ="8">내용</th>
			</tr>
			<tr class="tr1">
				<td colspan="8" height=auto><img src="#" id="pic"><td>
			</td>
			<tr class="tr5">
				<td colspan="8" >
				<input type="file" id="img" accept="image/*" name="f" onchange="PreviewImage();"/>
			</tr>
			<tr class="tr5">
				<td colspan="8"><a href="javascript:board_submit()">[게시물등록]</a></td>
			</tr>
	</table>
</form>

</section>
</div>

	
</body>
</html>