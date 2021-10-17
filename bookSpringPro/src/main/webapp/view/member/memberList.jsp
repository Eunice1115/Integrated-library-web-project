<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/memberCss/memberList.css">
</head>


<script>
//책 대출에 필요한 정보를 입력하는 창을 띄운다.
function rental() {
	window.open("<%=request.getContextPath() %>/book/rentalForm", 
			'rental', 'top=30, left=100, width=800, height=300')
}
</script>


<body>
	
<div id="box">
	<section id="section">
		
	<h3>회원리스트</h3>
		<div id="searchForm" >
	      <form action="<%=request.getContextPath() %>/member/memberList"  method="post">
		  회원검색&nbsp
		  <input type="text" name="req" value="${req}"/>
		  &nbsp&nbsp&nbsp<input type="submit" value="검색"/>
	      </form>
        </div>
				
		<table class="table"> 
			<tr class="tr1"> 
				<th>아이디</th>
				<th>이름</th>
				<th>비밀번호</th>
				<th>생일</th>
				<th>성별</th>
				<th>전화번호</th>
				<th>이메일</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach var="mem" items="${mlist}">
			<tr>
				<td>${mem.memberid}</td>
				<td>${mem.name}</td>
				<td>${mem.pass}</td>
				<td>${mem.birthday}</td>
				<td>${mem.gender}</td>
				<td>${mem.tel}</td>
				<td>${mem.email}</td>

				<td><a href="<%=request.getContextPath() %>/member/memberInfo?userid=${mem.memberid}">[회원정보]</a>
				<td><a href="<%=request.getContextPath() %>/member/memberUpdate?userid=${mem.memberid}">[수정]</a>
				<td><a href="<%=request.getContextPath() %>/member/memberDelete?userid=${mem.memberid}">[강제탈퇴]</a>
				<td><a href="<%=request.getContextPath() %>/book/bookReserveConfirm?memberid=${mem.memberid}">[도서예약내역]</a>
				<td><a href="<%=request.getContextPath() %>/book/bookRentalConfirm?memberid=${mem.memberid}">[대출내역]</a>
				<td><a href="<%=request.getContextPath() %>/boardev/evReserveConfirm?memberid=${mem.memberid}">[행사예약내역]</a>
				<td><a href="<%=request.getContextPath() %>/seat/seatlist?memberid=${mem.memberid}">[시설예약내역]</a>
			</tr>
			</c:forEach>
			
			<%--페이징 작업 --%>
			<tr>
				<td colspan="14">
				<%--한번에 보여질 수 있는 페이지 숫자는 3개이고, 현재 페이지가 3페이지 이하일 경우 [이전] 색은
				   회색으로 바뀐다.  --%>
				<c:if test="${startpage <= bottomLine}">
				<font color="grey"> [이전] </font>
				</c:if> 
				<%--[이전]버튼 선택시 현재의 페이지 넘버와 검색창에서 입력 받은 회원 아이디(req)를 같이 넘겨주는 작업--%>
				<c:if test="${startpage > bottomLine}">
				<a href="<%=request.getContextPath() %>/member/memberList?
					pageNum=${startpage - bottomLine}&req=${req}"><b>[이전]</b></a>
				</c:if> 
					
				<c:forEach var="a" begin="${startpage}" end="${endpage}">
				<%--현재 페이지가 3이면 3의 색깔을 파란색으로--%>
              	<c:if test="${a==pageNum}">
				<font color="blue"> [${a}] </font>
			 	</c:if>
			 	<%--페이지가 바뀌면 페이지넘버와 입력 받은 회원 아이디(req)를 같이 넘긴다.--%>
			  	<c:if test="${a!=pageNum}">
				<a href="<%=request.getContextPath() %>/member/memberList?pageNum=${a}&req=${req}">[${a}]</a>
			  	</c:if>
			    </c:forEach> 
			    <%--한번에 보여질 수 있는 페이지 숫자는 3개 이고, 현재 있는 페이지가 마지막 일경우 [다음]색은
			        회색으로 바뀐다.--%>
				<c:if test="${endpage >= maxpage}">
				<font color="grey"> [다음] </font>
				</c:if> 
				<%--[다음]버튼 선택시 현재의 페이지 넘버와 검색창에서 입력 받은 회원 아이디(req)를 같이 넘겨주는 작업--%>
				<c:if test="${endpage < maxpage}">
				<a href="<%=request.getContextPath() %>/member/meberList?
					pageNum=${startpage + bottomLine}&req=${req}"><b>[다음]</b></a>
				</c:if>
			    </td>		
	        </tr>
		</table>
			
			<input type="button" value="대출" class="button" onclick="rental()">
		</section>
	</div>
	
</body>
</html>