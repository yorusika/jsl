<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<style>
#clockbox{
position:absolute; 
display:inline-block; 
cursor:pointer;
 padding-left: 250px;
 padding-top:10px;
z-index: 5;
color: #0E9D4F;
 text-shadow: 1px 1px 0 #056D34, -1px -1px 0 #056D34;
}
#clockbox:active{
color: #056D34;
 text-shadow: none;
}

#tablebox{
position:relative; 
width:800; 
height:100;
 border-top:2px solid #039445; 
 border-bottom:2px solid #039445;
text-align:center;
margin: 0 auto;
z-index: 0;
}

table{

text-align:center;
}

td{

border-spacing: 10px 0px; 
text-align: center;
height:70px;
}
.container {
    padding-right: 5px;
    padding-left: 0px;
   
}

#bannerWrap{
	
	text-align:center;
	width:600px;
	height:100%;
	position:relative;
	margin:0 auto;

}
</style>

          <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<script>
	$(document).ready(function(){
				$("#tablebox").hide();
			
				$("#clock").click(function(){
				$("#tablebox").animate({width : 'toggle'},1000);
		
				});
				});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<div id="bannerWrap">
		<div id="clockbox"><i class="material-icons" style="font-size:50px;" id="clock">alarm</i></div>
		<div id="tablebox">
		<table id="todayBook">
				
			<tr>
			<td>
			</td>
				<c:if test="${todayBookList!=null}">
				<c:forEach var="today_book" items = "${todayBookList}" varStatus="status">
				<c:if test="${status.index<9}">
				<td>
					
					<a href="showBook.hong?book_id=${today_book.book_id}" target="_parent">
					<img src="/Hongwaka/book_images/${today_book.image_name}" style = "width:40px; heigth: 60px;"/>
					</a>
				</td>
					
				</c:if>
				</c:forEach>
					
			
				</c:if>
            	</tr>
				
		</table>
						
		
	</div>
	</div>
</div>
</body>
</html>