<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<script src="/Hongwaka/js/adminbook.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
			.content input[type="text"]{
			    width: 89%;
			    height : 200px;
			    padding: 10px 10px;
			    font-size: 1em;
			    border: none;
			    border-bottom: none;
			    outline: none;
			    color: #999;
			    float: left;
			    background: none;
			    text-align : top;
			}
			.content i {
				float: left;
			    color: #999;
			    font-size: 1.1em;
			    padding: 13px;
			}
			.content {
			    background: #fff;
			    border: 1px solid #999;
			    margin-bottom: 2em;
			}
		</style>
	</head>
	<body>
		<div>
		<%@ include file = "admin_header.jsp" %>
		</div>
		<div class="banner-top">
			<div class="container">
				<h3 >本の修正</h3>
				<h4><a href="/Hongwaka/view/adminmain.jsp">ホーム</a><label>/</label>本の修正</h4>
				<div class="clearfix"> </div>
			</div>
		</div>
		
		
		
		<div class="login">
		
		<c:if test = "${searchBook == null }">
		<div class="main-agileits">
				<div class="form-w3agile">
					<h3>本を探す</h3>
					<form action="searchBook.hong?action=modify" method="post">
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
		
		<c:if test = "${searchBook != null }">
			<div class="login">
		<div class="main-agileits">
			<div class="form-w3agile">
				<h3>本の修正</h3>
					<form action="modifyBook.hong?book_id=${searchBook.book_id }" enctype = "multipart/form-data" 
					method="post" name="modify" onsubmit="return modifycheck()">
					<div class="key">
						<i class="fa fa-star" aria-hidden="true"></i> <input type="text"
							value="${searchBook.name }" name="name" onfocus="this.value = '';" required="">
						<div class="clearfix"></div>
					</div>
					<h4>ジャンル</h4>
					<div class="key">
							<i class="fa fa-star" aria-hidden="true"></i> <input type="radio"
							name="kind" value="lit" <c:if test="${searchBook.kind eq 'lit'}">checked="checked"</c:if>>文学
							<input type="radio"
							name="kind" value="edu"<c:if test="${searchBook.kind eq 'edu'}">checked="checked"</c:if>>教育
							<input type="radio"
							name="kind" value="pol"<c:if test="${searchBook.kind eq 'pol'}">checked="checked"</c:if>>政治
							<input type="radio"
							name="kind" value="eco"<c:if test="${searchBook.kind eq 'eco'}">checked="checked"</c:if>>経済
							<input type="radio"
							name="kind" value="kid"<c:if test="${searchBook.kind eq 'kid'}">checked="checked"</c:if>>児童
					
						<div class="clearfix"></div>
					</div>
					<h4>著者</h4>
					<div class="key">
						<i class="fa fa-star" aria-hidden="true"></i> <input type="text"
							value="${searchBook.author }" name="author" onfocus="this.value = '';" required="">
						<div class="clearfix"></div>
					</div>
					<div>
						<h4>イメージ</h4>
						<input type="file" name="image_name" /> <br>
						<input type="hidden" name="origin_name" value="${searchBook.image_name}">
					</div>
					<h4>目次</h4>
					<div class="content">
						
						<textarea rows="6" cols="50" name="list">${searchBook.list} </textarea>
						<div class="clearfix"></div>
					</div>
					<h4>紹介</h4>
					<div class="content">
					<textarea rows="6" cols="50" name="introduce">${searchBook.introduce }</textarea>
						
						<div class="clearfix"></div>
					</div>
					<h4>著者紹介</h4>
					<div class="content">
						<textarea rows="6" cols="50" name="author_introduce">${searchBook.author_introduce }</textarea>
						
						<div class="clearfix"></div>
					</div>
					<h4>フォルダ名</h4>
					<div class="key">
						<input type="text" name="book_folder" value="${searchBook.book_folder }">
						<div class="clearfix"></div>
					</div>
					<h4>総ページ数</h4>
					<div class="key">
						<input type="text" name="book_page" value="${searchBook.book_page }">
						<div class="clearfix"></div>
					</div>
					<div class="add add-3">
						<input type="submit" value="修正" >
					</div>
				</form>
			</div>
		</div>
	</div>
</c:if>
	</body>
</html>