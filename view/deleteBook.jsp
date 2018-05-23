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
				<h3 >本の削除</h3>
				<h4><a href="/Hongwaka/view/adminmain.jsp">ホーム</a><label>/</label>本の削除</h4>
				<div class="clearfix"> </div>
			</div>
		</div>
		<div class="login">
		
		<c:if test = "${searchBook == null }">
		<div class="main-agileits">
				<div class="form-w3agile">
					<h3>本を探す</h3>
					<form action="searchBook.hong?action=delete" method="post">
						<h4>タイトルや著者名で検索</h4>
						<div class="key">
						<i class="fa fa-search" aria-hidden="true"></i>
							<input  type="text" name="search" required="">
							<div class="clearfix"></div>
						</div>
						<div class="add add-3">
						<input type="submit" value="検索">
						</div>
					</form>
				</div>
			</div>
		</div>
		</c:if>

	</body>
</html>