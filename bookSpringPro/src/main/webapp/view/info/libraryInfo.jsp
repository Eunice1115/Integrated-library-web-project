<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/infoCss/libraryInfo.css">
</head>

<body>
<div id="box">
	<%@include file = "../sidemenu/sidemenu4.jsp" %>
	<section id="section">


	<h3>도서관 정보</h3>
	<img src="<%=request.getContextPath() %>/img/line.jpg" class="line">
	
	<div id="titlehForm" >
		<img src="<%=request.getContextPath() %>/img/mark.png" width="15" height="15" > 도서관 소개
	</div>
	<h5> 저희 통합도서관은 논현, 대치, 삼성, 역삼, 청담, 세곡, 열린도서관 총 7개의 도서관을 통합하였습니다.
	<br> 이 도서관의 특징은 인기도서, 신착도서 등의 도서검색이 용이하고 각종 도서문화행사를 쉽게 접할 수 있으며 
	<br> 도서관 서비스를 통해 시설예약 및 다양한 정보를 얻을 수 있습니다.</h5>
	
	
	
	<div id="titlehForm" >
		<img src="<%=request.getContextPath() %>/img/mark.png" width="15" height="15" > 찾아오시는 길
	</div>
	
	<br>
		<!-- 지도 삽입 -->
	
		<div>
		<!-- * 1. 카카오맵 - 지도 노드  -->
		<div id="daumRoughmapContainer1632212059224"
			class="root_daum_roughmap root_daum_roughmap_landing" ></div>

		<!-- 2. 설치 스크립트: 지도 퍼가기 서비스  -->
		<script charset="UTF-8" class="daum_roughmap_loader_script"
				src="https://ssl.daumcdn.net/dmaps/map_js_init/roughmapLoader.js"></script>

		<!-- 3. 실행 스크립트 -->
		<script charset="UTF-8">
				new daum.roughmap.Lander({
					"timestamp" : "1632212059224",
					"key" : "27f8k", "mapWidth" : "680", "mapHeight" : "280"}).render();
		</script>
		</div>

		
	<h5>서울특별시 중구 세종대로 110</h5>

	<h4>교통정보안내</h4>
		<table class="table">
			<tr class="tr1">
				<th colspan="4">지하철 </th>
				<th colspan="4">버스 </th>
			</tr>
				<tr class="tr1">
				<td colspan="4" > 선정릉역 (9호선, 분당선) :
				<br>
				2번 출구 → 주유소에서 좌회전 → 삼릉초등학교 뒤편에 위치 </td>
				<td colspan="4">한국토지주택공사 하차 : 3426, 342, 472, 4412 	</td>
			</tr>
				<tr class="tr1">
				<td colspan="4">강남구청역(7호선, 분당선) :
				<br>
				1번 출구 → 편의점에서 좌회전 → 강남교육지원청 끝편에 위치</td>
				<td colspan="4"> 강남구청 하차 : 242, 301, 3011, 3414, 3426, 401, 강남08</td>
			</tr>
			<tr class="tr1">
				<td colspan="4">청담역(7호선) :
				<br> 
				7번 출구 → 상아APT에서 우회전 → 460m 직진 </td>
				<td colspan="4"> 삼성2동주민센터 하차 : 3412, 342, 강남07 </td>
			</tr>
		</table>

	<div id="titlehForm2" >
		<img src="<%=request.getContextPath() %>/img/mark.png"  width="15" height="15" > 주차안내
	</div>	
	
	<br>
	
	<p style="text-align:left;">
	&emsp; &nbsp; * 주차장 운영시간 <br>
	&emsp; &nbsp; -평일: 09:00 - 18:00 (도서관 이용자에 한해 30분 무료, 30분 이후에는 5분당 200원씩 가산)<br>
	&emsp; &nbsp; -토요일⸱일요일⸱공휴일 : 무료주차 <br>
	&emsp; &nbsp; -휴관일 : 개방 안함	<br>

	</section>
</div>
</body>
</html>