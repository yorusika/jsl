<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>


	<head>
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
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 
		newBookList가 null일경우 신간이 존재하지 않습니다 라는 메세지를 출력
		
		newBookList에 담겨있는 정보: 가장 최근에 들어온 책 10개가 담긴 배열
		
		newBookList의 책에 담긴 정보: book_id, image_name
		
		
		책의 제목이나 이름을 클릭했을때 book_id의 값을 book_id란 이름의 파라미터에 담아서 
		/Hongwaka/showBook.hong으로 넘겨주되 이때 앵커 태그에 target="_parent"를 추가한다.

		 -->		
		<div class="container">
		<h2>新着の小説</h2>
		<br>
		<div id="bannerWrap">
			<div class="frame">
				<ul id="bannerList">
				<c:forEach var = "new_book" items = "${newBookList}" varStatus = "status">
					<li><a href="showBook.hong?book_id=${new_book.book_id }" target="_parent">
					<img src="/Hongwaka/book_images/${new_book.image_name }" style = "width:120px; heigth: 200px;"></a></li>
				</c:forEach>
				</ul>
				<button class="leftBtn2" onclick="moveBanner('leftBtn')">◀</button>
				<button class="rightBtn2" onclick="moveBanner('rightBtn')">▶</button>
				<br> <br>
			</div>
		</div>
	</div>
	</body>
</html>