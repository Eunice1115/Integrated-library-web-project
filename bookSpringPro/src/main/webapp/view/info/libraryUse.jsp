<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/infoCss/libraryUse.css">

</head>
<body>
<div id="box">
	<%@include file = "../sidemenu/sidemenu4.jsp" %>
	<section id="section">

		
 <h3>도서관 이용 안내</h3>
	<img src="<%=request.getContextPath() %>/img/line.jpg" class="line">
	
	<div id="titlehForm" >
		<img src="<%=request.getContextPath() %>/img/mark.png" width="15" height="15" > 이용시간 
	</div>	
	
	<table class='table'>
	<tr class="tr1">
		<th colspan="2">구분 </th>
		<th colspan="4">평일 </th>
		<th colspan="2">주말 </th>		
	</tr>
	<tr class="tr1">
		<td colspan="2">일반열람실</td>
		<td colspan="4">07:00 - 23:00 (3월~10월) <br> 08:00 - 22:00 (11월~2월)</td>
		<td colspan="2">07:00 - 22:00 (3월~10월) <br> 08:00 - 22:00 (11월~2월)</td>
	</tr>
	<tr class="tr1">
		<td colspan="2">청소년열람실</td>
		<td colspan="4">09:00 - 18:00</td>
		<td colspan="2"   rowspan="2">09:00 - 17:00</td>
	</tr>
	<tr class="tr1">
		<td colspan="2">노트북열람실</td>
		<td colspan="4">09:00 - 20:00</td>
		<td colspan="2"> </td>
	</tr>
	</table>
	
	<br>

	<div id="titlehForm" >
		<img src="<%=request.getContextPath() %>/img/mark.png"  width="15" height="15" > 휴관일
	</div>	
	<br>
	&emsp; &nbsp;
	* 정기휴관일 : 매월 첫째· 셋째 수요일 , 일요일을 제외한 법정공휴일 (공휴일과 일요일이 겹칠 경우, 휴관)
	<br>	
	&emsp; &nbsp;
	* 임시휴관일 : 도서관 사정으로 임시로 정하는 휴일


</section>
</div>
</body>
</html>