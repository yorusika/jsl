<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
	</head>
	<body>
		 <div>
           
               <%@ include file= "header.jsp"%> 
        </div>
        <div class="banner-top">
			<div class="container">
				<h3>ログイン</h3>
				<h4>
					<a href="/Hongwaka/index.jsp">ホーム</a><label>/</label>ログイン
				</h4>
				<div class="clearfix"></div>
			</div>
		</div>
        
        <div class="login">
	
		<div class="main-agileits">
				<div class="form-w3agile">
					<h3>ログイン</h3>
					<form action="/Hongwaka/login.hong" method="post">
					<input type="hidden" name="command" value="login"/>
						<div class="key">
							<i class="fa fa-user" aria-hidden="true"></i>
							<input  type="text" name="id">
							<div class="clearfix"></div>
						</div>
						<div class="key">
							<i class="fa fa-lock" aria-hidden="true"></i>
							<input  type="password" name="pass"/>
							<div class="clearfix"></div>
							
						</div>
						<div class = "add add-3">
						<input type="submit" value="ログイン">
						</div>
					</form>
				</div>
				
			</div>
		</div>
        
        
	</body>
</html>