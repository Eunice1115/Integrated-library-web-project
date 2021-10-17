<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/guide.css">
</head>
<body>

<nav id="sidemenu">

<div class="submenu">
	<ul>
		<li class="lititle">도서관 서비스
		<li class="li"><a href="<%=request.getContextPath() %>/info/libUse">도서관 이용</a>
		<li class="li"><a href="<%=request.getContextPath() %>/info/libInfo">도서관 정보</a>
		<li class="li"><a href="<%=request.getContextPath() %>/seat/seatInfo">시설 예약</a>
	</ul>

</div>

</nav>

</body>
</html>