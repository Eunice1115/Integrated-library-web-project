<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberCss/siteMap.css">
</head>
<body>

<div id="box">

<%@include file = "../sidemenu/guide.jsp" %> 

<div class="content">

	<ul class="allcontent">
		<li class="content1"><a href="<%=request.getContextPath()%>/book/booklist">자료검색</a>
			<ul class="subcontent">
				<li class="content2"><a href="<%=request.getContextPath()%>/book/booklist">도서검색</a></li>
				<li class="content2"><a href="<%=request.getContextPath()%>/book/newbooklist">신착도서</a></li>
				<li class="content2"><a href="<%=request.getContextPath()%>/book/bestBookList">인기도서</a></li>
			</ul>
		</li>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="content1"><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=1">독서문화행사</a>
			<ul  class="subcontent">
				<li class="content2"><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=1">지역행사</a></li>
				<li class="content2"><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=2">강연</a></li>
				<li class="content2"><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=3">체험프로그램</a></li>
				<li class="content2"><a href="<%=request.getContextPath() %>/boardev/evlist?boardid_ev=4">이벤트</a></li>
			</ul>
		</li>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		<li class="content1"><a href="<%=request.getContextPath() %>/info/libUse">도서관 서비스</a>
			<ul  class="subcontent">
				<li class="content2"><a href="<%=request.getContextPath() %>/info/libUse">도서관 이용</a></li>
				<li class="content2"><a href="<%=request.getContextPath() %>/info/libInfo">도서관 정보</a></li>
				<li class="content2"><a href="<%=request.getContextPath() %>/seat/seatInfo">시설예약</a></li>
			</ul>
		</li>
		&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
		
		<li class="content1"><a href="<%=request.getContextPath() %>/board/list?boardid=1">열린마당</a>
			<ul  class="subcontent">
				<li class="content2"><a href="<%=request.getContextPath() %>/board/list?boardid=1">공지사항</a></li>
				<li class="content2"><a href="<%=request.getContextPath() %>/board/faqForm">FAQ</a></li>
				<li class="content2"><a href="<%=request.getContextPath() %>/board/list?boardid=2">건의사항</a></li>
			</ul>
		</li>
	</ul>

</div>

</div>

</body>
</html>