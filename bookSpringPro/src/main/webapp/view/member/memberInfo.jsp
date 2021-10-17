<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberCss/memberInfo.css">
</head>

<body>
<div id="box">
		<section id="section">

		<h3>회원정보</h3>

		<table class="table">
			<tr>
				<td class="name">아이디</td>
				<td class="data">${member.memberid}</td>
			</tr>
			
			<tr>
				<td class="name">비밀번호</td>
				<td class="data">${member.pass}</td>
			</tr>
			
			
			<tr>
				<td class="name">이름</td>
				<td class="data">${member.name}</td>
			</tr>
			
			<tr>
				<td class="name">성별</td>
				<td class="data">${member.gender}</td>
			</tr>
			
			<tr>
				<td class="name">생일</td>
				<td class="data">${member.birthday}</td>
			</tr>
			
			<tr>
				<td class="name">이메일</td>
				<td class="data">${member.email}</td>
			</tr>
			
			
			<tr>
				<td class="name">휴대전화</td>
				<td class="data">${member.tel}</td>
			</tr>
			
			<c:if test="${login == member.memberid}">
			<tr>
				<td colspan="7" class="button">
				<input type="button"   
				value="도서예약내역"
				onclick="location.href='<%=request.getContextPath() %>/book/bookReserveConfirm?memberid=${member.memberid }'" >
				<input type="button"  
				value="시설예약내역"
				onclick="location.href='<%=request.getContextPath() %>/seat/seatList?memberid=${member.memberid}'" >
				<input type="button"   
				value="대출내역"
				onclick="location.href='<%=request.getContextPath() %>/book/bookRentalConfirm?memberid=${member.memberid}'" >
				<br>
				<input type="button"   
				value="행사예약내역"
				onclick="location.href='<%=request.getContextPath() %>/boardev/evReserveConfirm?memberid=${member.memberid}'" >
				<input type="button"  
				value="회원정보수정"  
				onclick="location.href='<%=request.getContextPath() %>/member/memberUpdate?userid=${member.memberid }'" >
				<input type="button"   
				value="회원탈퇴"
				onclick="location.href='<%=request.getContextPath() %>/member/memberDelete?userid=${member.memberid }'" >
				</td>
			</tr>
			</c:if>
		</table>
		
	</section>
</div>
</body>
</html>