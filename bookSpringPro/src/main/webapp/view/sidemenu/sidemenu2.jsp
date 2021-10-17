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
		<li class="lititle">자료검색
		<li class="li"><a href="<%=request.getContextPath()%>/book/booklist">도서검색</a>
		<li class="li"><a href="<%=request.getContextPath()%>/book/newbooklist">신착도서</a>
		<li class="li"><a href="<%=request.getContextPath()%>/book/bestBookList">인기도서</a>
	</ul>

</div>

</nav>

</body>
</html>