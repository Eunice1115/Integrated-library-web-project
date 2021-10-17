<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>통합도서관</title>

<script
	src="https://kit.fontawesome.com/2d323a629b.js"
	crossorigin = "anonymous">
	
</script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/css/headstyle.css">
<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">

</head>

<nav id="header" class="clearfix">
	<div class="sitemap">
		<ul class="clearfix">
			<li class="li"><a href="<%=request.getContextPath()%>/member/siteMap">사이트맵</a>
			<li class="slash">|</li>
			<c:if test="${login == null }">
			<li class="li"><a href="<%=request.getContextPath()%>/member/loginForm">로그인</a>
			<li class="slash">|</li>
			<li class="li"><a href="<%=request.getContextPath()%>/member/memberInput">회원가입</a>
			</c:if>
				
			<c:if test="${login != null }">
			<li class="li"><a href="<%=request.getContextPath() %>/member/memberInfo?userid=${login}">My library</a>
			<li class="slash">|</li>
			<li class="li"><a href="<%=request.getContextPath()%>/member/logOut">로그아웃</a>
				
			<c:if test="${login eq 'admin' }">
			<li class="slash">|</li>
			<li class="li"><a href="<%=request.getContextPath()%>/member/memberList">회원리스트</a>
			</c:if>
            </c:if>
		</ul>
	</div>
	
<nav id="navbar" class="clearfix">
	<div class="navbar_logo">
		<i class="fab fa-accusoft"></i>
		<a href="<%=request.getContextPath()%>/member/main">통합도서관</a>
	</div>
		
	<div class="navbar_menu">
		<ul class="clearfix" >
			<li class="mainmenu"><a href="<%=request.getContextPath()%>/book/booklist" class="content">자료검색</a>
				<ul class="submenu">
					<li><a href="<%=request.getContextPath()%>/book/booklist">도서검색</a></li>
					<li><a href="<%=request.getContextPath()%>/book/newbooklist">신착도서</a></li>
					<li><a href="<%=request.getContextPath()%>/book/bestBookList">인기도서</a></li>
				</ul>
			</li>
				
			<li class="mainmenu"><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=1" class="content">독서문화행사</a>
				<ul class="submenu">
					<li><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=1">지역행사</a></li>
					<li><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=2">강연</a></li>
					<li><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=3">체험프로그램</a></li>
					<li><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=4">이벤트</a></li>
				</ul>
			</li>
				
			<li class="mainmenu"><a href="<%=request.getContextPath() %>/info/libUse" class="content">도서관 서비스</a>
				<ul class="submenu">
					<li><a href="<%=request.getContextPath() %>/info/libUse">도서관 이용</a></li>
					<li><a href="<%=request.getContextPath() %>/info/libInfo">도서관 정보</a></li>
					<li><a href="<%=request.getContextPath() %>/seat/seatInfo">시설 예약</a></li>
				</ul>
			</li>
				
			<li class="mainmenu"><a href="<%=request.getContextPath() %>/board/list?boardid=1" class="content">열린마당</a>
				<ul class="submenu">
				    <li><a href="<%=request.getContextPath() %>/board/list?boardid=1">공지사항</a></li>
					<li><a href="<%=request.getContextPath() %>/board/faqForm">FAQ</a></li>
					<li><a href="<%=request.getContextPath() %>/board/list?boardid=2">건의사항</a></li>
				</ul>
			</li>
		</ul>
	</div>
		
</nav>
	
</nav>

</html>