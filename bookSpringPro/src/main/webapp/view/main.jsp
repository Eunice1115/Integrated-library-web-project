<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../css/mainStyle.css">

</head>
<body >

<div id="box">
  
	<div id="banner" >
       <br><br>
		<img src="../img/banner.png"  alt="도서관 소개">
	</div>

	
	<section class="content">
		<section id="cont-left">
			<div class="left" ></div>			
		</section>
						
		<section id="cont-center">
			<section class="slider">
				<div class="slide" style="background-image : url('../img/img1.jpg')"></div>
				<div class="slide" style="background-image : url('../img/img2.jpg')"></div>
				<div class="slide" style="background-image : url('../img/img3.jpg')"></div>
				<div class="slide" style="background-image : url('../img/img4.jpg')"></div>
				
				<a class="prev" onclick="button_click(-1)">&#10094</a>
				<a class="next" onclick="button_click(1)">&#10095</a>
			</section>
		</section>
		
		<section id="cont-right">
			<div class="right">
			  	<ul class="a1">
			     <li class="b1" style="font-weight : 900"><a href="<%=request.getContextPath()%>/member/main">강남구</a>
			     <li class="b1" style="font-weight : 500"><a href="https://library.gangnam.go.kr/nhlib/index.do">논현</a>
			     <li class="b1" style="font-weight : 500"><a href="https://library.gangnam.go.kr/dchlib/index.do">대치</a>
			     <li class="b1" style="font-weight : 500"><a href="https://library.gangnam.go.kr/sslib/index.do">삼성</a>
			     <li class="b1" style="font-weight : 500"><a href="https://library.gangnam.go.kr/yslib/index.do">역삼</a>
			     <li class="b1" style="font-weight : 500"><a href="https://library.gangnam.go.kr/cdlib/index.do">청담</a>
			     <li class="b1" style="font-weight : 500"><a href="https://library.gangnam.go.kr/sklib/index.do">세곡</a>
			     <li class="b1" style="font-weight : 500"><a href="https://library.gangnam.go.kr/yllib/index.do">열린</a>
			    </ul>
			</div>			
		</section>
	</section>
</div>
</body>

<script>
//이미지 슬라이드 수동으로 넘기는 작업
	let currSlide = 1;
	showSlide(currSlide);
	
	function button_click(num){
		showSlide((currSlide += num))
	}
	
	function showSlide(num){
		const slides = document.querySelectorAll(".slide");
		if(num>slides.length){
			currSlide=1;
			
		}if(num<1){
			currSlide=slides.length;
		}
		for(let i=0; i<slides.length; i++){
			slides[i].style.display="none";
		}slides[currSlide -1].style.display = "block";
	}

//이미지 슬라이드 자동으로 넘어가는 작업
	var index = 0;
	window.onload = function(){
		slideShow();
	}
	
	function slideShow(){
		var i;
		var x = document.getElementsByClassName("slide");
	
		for(i=0; i<x.length ; i++){
			x[i].style.display="none";
		}
		index++;
		
		if(index>x.length){
			index=1;
		}
		x[index-1].style.display = "block";
		setTimeout(slideShow,3000);
	}
	
</script>
</html>