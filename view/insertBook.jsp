<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.content input[type="text"] {
	width: 89%;
	height: 200px;
	padding: 10px 10px;
	font-size: 1em;
	border: none;
	border-bottom: none;
	outline: none;
	color: #999;
	float: left;
	background: none;
	text-align: top;
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
<script src="/Hongwaka/js/adminbook.js"></script>
</head>
<body>
	<div>
		<%@ include file="admin_header.jsp"%>
	</div>
	<div class="banner-top">
		<div class="container">
				<h3 >本の登録</h3>
				<h4><a href="/Hongwaka/view/adminmain.jsp">ホーム</a><label>/</label>本の登録</h4>
			<div class="clearfix"></div>
		</div>
	</div>
	<div class="login">
		<div class="main-agileits">
			<div class="form-w3agile">
				<form action="addBook.hong" enctype="multipart/form-data"
					method="post" name="admin" onsubmit="return filecheck()">
					<h4>タイトル</h4>
					<div class="key">
						<i class="fa fa-star" aria-hidden="true"></i> <input type="text"
							name="name" onfocus="this.value = '';" required="">
						<div class="clearfix"></div>
					</div>
					<h4>ジャンル</h4>
					<div class="key">
						<i class="fa fa-star" aria-hidden="true"></i> <input type="radio"
							name="kind" value="lit" checked="checked">文学
							<input type="radio"
							name="kind" value="edu">教育
							<input type="radio"
							name="kind" value="pol">政治
							<input type="radio"
							name="kind" value="eco">経済
							<input type="radio"
							name="kind" value="kid">児童
						<div class="clearfix"></div>
					</div>
					<h4>著者</h4>
					<div class="key">
						<i class="fa fa-star" aria-hidden="true"></i> <input type="text"
							name="author" onfocus="this.value = '';" required="">
						<div class="clearfix"></div>
					</div>
					<div>
						<h4>イメージ</h4>
						<input type="file" name="image_name" /> <br>
					</div>
					<h4>目次</h4>
					<div class="content">
						<textarea rows="6" cols="50" name="list"></textarea>
						<div class="clearfix"></div>
					</div>
					<h4>紹介</h4>
					<div class="content">
						<textarea rows="6" cols="50"name="introduce"></textarea>
		
						<div class="clearfix"></div>
					</div>
					<h4>著者紹介</h4>
					<div class="content">
						<textarea rows="6" cols="50" name="author_introduce"></textarea>
					
						<div class="clearfix"></div>
					</div>
					<h4>フォルダ名</h4>
					<div class="key">
						<input type="text" name="book_folder">
						<div class="clearfix"></div>
					</div>
					<h4>総ページ数</h4>
					<div class="key">
						<input type="text" name="book_page">
						<div class="clearfix"></div>
					</div>
					<div class="add add-3">
						<input type="submit" value="登録">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>