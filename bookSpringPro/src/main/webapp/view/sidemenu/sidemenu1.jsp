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
		<li class="lititle">열린마당
		<li class="li"><a href="<%=request.getContextPath() %>/board/list?boardid=1">공지사항</a>
		<li class="li"><a href="<%=request.getContextPath() %>/board/faqForm">FAQ</a>
		<li class="li"><a href="<%=request.getContextPath() %>/board/list?boardid=2">건의사항</a>
	</ul>

</div>

</nav>

</body>
</html>