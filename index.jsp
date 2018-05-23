<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
		.btn{
				width : 6px;
				height : 8px;
				border : 0;
				top: 45px;
		}	
		img{
			width:100px;
			height:200px;
			vertical-align:top;
			border:0;
		}
	</style>
	<script src="/Hongwaka/js/banner.js"></script>
	
</head>
<body>
	<div>
		<%@ include file="/view/header.jsp"%>
	</div>
	<div class="container">
	<div class = "info-form">
		<div class="banner-info">
			<div class="search-form">
				<form action="search.hong" method="post">
					<h3 style="color: #a1d88f; text-shadow: 2px 2px 2px #025226;">本を探す</h3>
					<input type="text" placeholder="タイトルで検索" name="search"> 
					<input type="submit" value="">
				</form>
			</div>
		</div>
	</div>
	</div>

	<!-- 신규도서목록 -->

			
		<div class = "add add-3">
			<iframe  width="800" height="300" src="/Hongwaka/newBookList.hong" frameborder = "0" >
			</iframe>
		</div>
		
		
		
			 <!-- 가장 많이 읽힌 책 띄워줄 iframe 
			 rankingList.hong에서 비즈니스 로직을 완료해서
			 rankingListShow.jsp에 결과 화면을 띄워준다. 
			 rankingListShow.jsp를 참조할 것
			  -->
		
		<div class = "add add-3">
			<iframe  width="800" height="300" src="/Hongwaka/rankingList.hong" frameborder = "0" >
			</iframe>
		</div>
		
		
		<div class = "add add-3">
			<iframe width="800" height="100" src="/Hongwaka/todayList.hong" frameborder = "0" scrolling="no">
			</iframe>
		</div>
		

	<br>


</body>
</html>