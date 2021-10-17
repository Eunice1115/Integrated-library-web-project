<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/seatCss/seatInfo.css">
</head>

<script>
function seatInput(){
	window.open("<%=request.getContextPath() %>/seat/seatInput?memberid=${login}", 
		'seatInput', 'top=10, left=10, width=500, height=300')
}

function seatUpdate(){
	window.open("<%=request.getContextPath() %>/seat/seatUpdate?memberid=${login}", 
		'seatUpdate', 'top=10, left=10, width=500, height=300')
}

function seatDelete(){
	window.open("<%=request.getContextPath() %>/seat/seatDelete?memberid=${login}", 
		'seatDelete', 'top=10, left=10, width=500, height=300')
}

function loginAlert(){
	alert("로그인이 필요한 서비스입니다")
}

</script>

<body>
<div id="box">
	<%@include file = "../sidemenu/sidemenu4.jsp" %>

<form action="<%=request.getContextPath() %>/seat/seatInputPro"  method="post">
<br><br><br><br><br><br><br><br>

<div id="box">
	<section id="section">
			
	<table class='table'>
		<tr class="tr1">
			<th colspan="7">열람실 현황</th>
		</tr>
		<tr class="tr1">
			<th colspan="7">일반열람실</th>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="1"></td>
			<td><input type="button" value="2"></td>
			<td><input type="button" value="3"></td>
			<td><input type="button" value="4"></td>
			<td><input type="button" value="5"></td>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="6"></td>
			<td><input type="button" value="7"></td>
			<td><input type="button" value="8"></td>
			<td><input type="button" value="9"></td>
			<td><input type="button" value="10"></td>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="11"></td>
			<td><input type="button" value="12"></td>
			<td><input type="button" value="13"></td>
			<td><input type="button" value="14"></td>
			<td><input type="button" value="15"></td>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="16"></td>
			<td><input type="button" value="17"></td>
			<td><input type="button" value="18"></td>
			<td><input type="button" value="19"></td>
			<td><input type="button" value="20"></td>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="21"></td>
			<td><input type="button" value="22"></td>
			<td><input type="button" value="23"></td>
			<td><input type="button" value="24"></td>
			<td><input type="button" value="25"></td>
		</tr>
		<tr class="tr1">
			<th colspan="7">청소년열람실</th>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="26"></td>
			<td><input type="button" value="27"></td>
			<td><input type="button" value="28"></td>
			<td><input type="button" value="29"></td>
			<td><input type="button" value="30"></td>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="31"></td>
			<td><input type="button" value="32"></td>
			<td><input type="button" value="33"></td>
			<td><input type="button" value="34"></td>
			<td><input type="button" value="35"></td>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="36"></td>
			<td><input type="button" value="37"></td>
			<td><input type="button" value="38"></td>
			<td><input type="button" value="39"></td>
			<td><input type="button" value="40"></td>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="41"></td>
			<td><input type="button" value="42"></td>
			<td><input type="button" value="43"></td>
			<td><input type="button" value="44"></td>
			<td><input type="button" value="45"></td>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="46"></td>
			<td><input type="button" value="47"></td>
			<td><input type="button" value="48"></td>
			<td><input type="button" value="49"></td>
			<td><input type="button" value="50"></td>
		</tr>
		<tr class="tr1">
			<th colspan="7">노트북열람실</th>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="51"></td>
			<td><input type="button" value="52"></td>
			<td><input type="button" value="53"></td>
			<td><input type="button" value="54"></td>
			<td><input type="button" value="55"></td>
		</tr>
		<tr class="tr1">
			<td><input type="button" value="56"></td>
			<td><input type="button" value="57"></td>
			<td><input type="button" value="58"></td>
			<td><input type="button" value="59"></td>
			<td><input type="button" value="60"></td>
		</tr>
	</table>
	
	<br>
	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
	&emsp;&emsp;
	
	<c:if test="${login!=null}">
	<input type="button" class="button" value="입실" onclick="seatInput()">
	&emsp;&emsp;&emsp;
	<input type="button" class="button" value="연장" onclick="seatUpdate()">
	&emsp;&emsp;&emsp;
	<input type="button" class="button" value="퇴실" onclick="seatDelete()">
	</c:if>
	<c:if test="${login==null}">
	<input type="button" class="button" value="입실" onclick="loginAlert()">
	&emsp;&emsp;&emsp;
	<input type="button" class="button" value="연장" onclick="loginAlert()">
	&emsp;&emsp;&emsp;
	<input type="button" class="button" value="퇴실" onclick="loginAlert()">
	</c:if>
	</section>
</div>

</form>

</div>
</body>

</html>