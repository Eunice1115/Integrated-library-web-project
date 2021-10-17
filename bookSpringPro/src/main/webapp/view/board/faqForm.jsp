<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/boardCss/faqForm.css">
</head>

<body>

<div id="box">
	<%@include file = "../sidemenu/sidemenu1.jsp" %>
<section id="section">


<h3>FAQ</h3>

<div class="accordion">
	<input type="checkbox" id="answer01">
	<label for="answer01">Q. 빌리고 싶은 도서를 예약하려면 어떻게 해야 하나요?</label>
	<div>
	<br>
	<p>&nbsp&nbsp&nbspA. 예약은 회원가입한 회원만 이용가능한 서비스입니다.</p>
	<p>&nbsp&nbsp&nbsp회원가입후 도서정보를 확인하면 예약버튼이 생성될 것이며 </p>
	<p>&nbsp&nbsp&nbsp대출중인 도서만 예약할 수 있습니다. </p>
	<p>&nbsp&nbsp&nbsp예약내역은 My library에서 확인하실 수 있습니다.</p>
	<p>&nbsp&nbsp&nbsp예약된 책을 확인하는 것 뿐만 아니라 취소도 My library에서 하는 것이 가능합니다.</p>
	<br>
	</div>
	<input type="checkbox" id="answer02">
	<label for="answer02">Q. 대출자료의 이용기간을 연장하려면 어떻게 해야 하나요?</label>
	<div>
	<br>
	<p>&nbsp&nbsp&nbspA. 정회원으로 로그인 하신 후 My library에 가면 대출내역을 확인하실 수 있습니다.</p>
	<p>&nbsp&nbsp&nbsp대출하신 자료 옆에 연장버튼을 클릭하면 자동연장됩니다.</p>
	<p>&nbsp&nbsp&nbsp연장은 2회까지 가능하며 한 번 연장될때마다 1주일씩 연장됩니다.</p>
	<br>
	</div>
	<input type="checkbox" id="answer03">
	<label for="answer03">Q. 독서문화행사 예약은 어떻게 해야 하나요?</label>
	<div>
	<br>
	<p>&nbsp&nbsp&nbspA. 독서문화행사 예약은 정회원만 가능합니다.</p>
	<p>&nbsp&nbsp&nbsp예약은 매번 선착순으로 진행되며 정원이 채워지면 예약하실 수 없습니다.</p>
	<p>&nbsp&nbsp&nbsp하지만 정원이 채워져도 누군가 취소한다면 바로 예약하실 수 있습니다.</p>
	<br>
	</div>
	<input type="checkbox" id="answer04">
	<label for="answer04">Q. 회원정보는 어떻게 수정하나요?</label>
	<div>
	<br>
	<p>&nbsp&nbsp&nbspA. My library -> 회원정보 수정에서 수정하실 수 있습니다.</p>
	<p>&nbsp&nbsp&nbsp수정시 가입했을 때 비밀번호와 동일한 비밀번호를 입력해야 수정이 가능합니다.</p>
	<br>
	</div>
	<input type="checkbox" id="answer05">
	<label for="answer05">Q. 열람실 이용은 어떻게 하나요?</label>
	<div>
	<br>
	<p>&nbsp&nbsp&nbspA. 도서관 서비스 -> 시설예약에서 열람실을 이용할 수 있으며</p>
	<p>&nbsp&nbsp&nbsp연장, 퇴실시에도 시설예약 페이지에서 가능합니다.</p>
	<p>&nbsp&nbsp&nbsp시설예약내역은 My library에서 확인하실 수 있으나 </p>
	<p>&nbsp&nbsp&nbsp연장, 퇴실은 시설예약 페이지에서만 가능합니다.</p>
	<br>
	</div>
</div>
	
</section>

</div>
	
</body>
</html>