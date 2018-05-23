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
</head>
<body>
<div><%@ include file="/view/admin_header.jsp"%></div>
<div class="banner-top">
			<div class="container">
				<h3 >管理者ページ</h3>
				<!-- <h4><a href="index.html">Home</a><label>/</label>Admin</h4> -->
				<div class="clearfix"> </div>
			</div>
			</div>
<div><Center><h3>管理者ページです。本の登録、修正、削除機能がご利用できます。</h3>
<br><br>
<a href="/Hongwaka/logout.hong">ログアウト</a>
</Center></div>
</body>
</html>