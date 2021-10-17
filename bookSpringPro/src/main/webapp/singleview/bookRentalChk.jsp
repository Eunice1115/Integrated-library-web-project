<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function closeTabClick(){
	window.close();
}
</script>
<style>
h3{
	margin-top:25vh;
	margin-left:6vw;
	font-size:2vw;
	text-align:center;
}

.table{
	width:70%;
	margin-top:3vh;
	margin-left:15%;
	border-collapse: collapse;
}

.table .tr1{
	border:solid 0.5px;
	border-collapse: collapse;
	border-color:#8C8CFF;
	text-align:center;
}

.table .tr1 th{
	height:4vh;
	border:solid 0.5px;
	border-collapse: collapse;
	border-color:#8C8CFF;
	text-align:center;
	background:lavender;
}

.table td{
	height:4vh;
	border:solid 0.5px;
	border-collapse: collapse;
	border-color:#8C8CFF;
	text-align:center;
	font-size:1vw;
}

input[type=button]{
	margin-top:4vh;
	margin-left:49vw;
	width:6vw;
	height:8vh;
	font-size:1vw;
	text-align:center;
	border-color:#8C8CFF;
	background:lavender;
	
}
</style>
</head>
<body>


<h3>대출확인</h3>
<table class="table">
		<tr class="tr1">
		  <th>대출번호</th>
		  <th>책번호</th>
		  <th>책이름</th>
		  <th>작가</th>
		  <th>출판사</th>
		  <th>대출일</th>
		  <th>반납예정일</th>
		</tr>
		
		<tr class="tr1">
		  <td>${rental.rentalnum }</td>
		  <td>${rental.booknum }</td>
		  <td>${book.bookname }</td>
		  <td>${book.author}</td>
		  <td>${book.publisher }</td>
		  <td>${rental.rentaldate }</td>
		  <td>${rental.returndate_sch }</td>
	</table>
	
	<input type="button" value="닫기" class="button" onclick="closeTabClick()">
			
			
	
</body>
</html>