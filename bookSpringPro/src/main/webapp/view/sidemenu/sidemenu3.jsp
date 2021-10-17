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
		<li class="lititle">독서문화행사
		<li class="li"><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=1">지역행사</a>
		<li class="li"><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=2">강연</a>
		<li class="li"><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=3">체험프로그램</a>
		<li class="li"><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=4">이벤트</a>
	</ul>

</div>

</nav>

</body>
</html>