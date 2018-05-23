<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div>
		<%@ include file = "admin_header.jsp" %>
		</div>
		<div class="banner-top">
			<div class="container">
				<c:choose>
				<c:when test="${param.action eq 'modify'}">
				<h3 >本の修正</h3>
				</c:when>
				<c:otherwise>
				<h3 >本の削除</h3>
				</c:otherwise>
				</c:choose>
				
				<h4><a href="/Hongwaka/view/adminmain.jsp">ホーム</a><label>/</label>
				<c:choose>
				<c:when test="${param.action eq 'modify'}">
				本の修正
				</c:when>
				<c:otherwise>
				本の削除
				</c:otherwise>
				</c:choose>
				</h4>
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="login">
	
		
		<div class = "container">
		<div class = "wood">
		<table class="table ">
		  <tr>
		  	<th class="t-head">ID</th>
			<th class="t-head head-it ">本</th>
			<th class="t-head">タイトル</th>
			<th class="t-head">著者</th>
			<c:choose>
			<c:when test="${param.action eq 'modify'}">
			<th class = "t-head"> 修正 </th>
			</c:when>
			<c:otherwise>
			<th class = "t-head"> 削除 </th>
			</c:otherwise>
			</c:choose>
		  </tr>
		<c:forEach var="searchBook" items="${searchBooks}" varStatus="status">
		  <tr class="cross">
		  	<td class ="t-data">${searchBook.book_id }</td>
			<td class="ring-in t-data">
				
					<img src="/Hongwaka/book_images/${searchBook.image_name }" class="img-responsive" alt="">
				
			 </td>
			 <td class = "t-data">${searchBook.name }</td>				
			<td class="t-data">${searchBook.author }</td>
			<c:choose>
			<c:when test="${param.action eq 'modify'}">
			<td class="t-data"><a class=" add-1" href="oneBookSearch.hong?book_id=${searchBook.book_id }&&search=${search}">修正</a></td>
			</c:when>
			<c:otherwise>
			<td class="t-data"><a class=" add-1" href="deleteBook.hong?book_id=${searchBook.book_id }&&search=${search}">削除</a></td>
			</c:otherwise>	
			</c:choose>	
		  </tr>
		</c:forEach>
		  </table> <br><br>
		</div>
		</div>
	</body>
</html>