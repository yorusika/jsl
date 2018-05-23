<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
		   <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
          <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
          <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.css">
          <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">
          <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css">
          <link rel="stylesheet" href="${pageContext.request.contextPath}/css/jstarbox.css">
          <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
          <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
          <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
          <script src="/Hongwaka/js/banner.js"></script>	
</head>
<body>


	<!-- 
	rankingList가 null일 경우 "책이 등록되어 있지 않습니다."라는 오류메시지를 띄워준다.
	
	rankingList에 담겨있는 정보: 가장 Hit 수가 높은 책 5권이 담겨있는 Book배열
	
	rankingList의 책에 담겨있는 정보: book_id, image_name, hit
	
	
	책의 제목이나 이름을 클릭 했을 때 book_id의 값을 book_id란 이름의 파라미터에 담아서 
	/Hongwaka/showBook.hong 에 넘겨주되 이때 앵커  태그에 target="_parent"를 추가한다.
 
	  -->
	 	<div class="container">
		<h2>人気小説</h2>
		<br>
		<div id="bannerWrap">
			<div class="frame">
				<ul id="bannerListb">
				<c:forEach var = "ranking_book" items = "${rankingList}" varStatus = "status">
					<li><a href="showBook.hong?book_id=${ranking_book.book_id }"  target="_parent">
					<img src="/Hongwaka/book_images/${ranking_book.image_name }" style = "width:120px; heigth:200px"></a></li>
				</c:forEach>
				</ul>
				<button class="leftBtn2" onclick="moveBannerb('leftBtn')">◀</button>
				<button class="rightBtn2" onclick="moveBannerb('rightBtn')">▶</button>
				<br> <br>
			</div>
		</div>
	</div> 
	  
	  
	
</body>
</html>