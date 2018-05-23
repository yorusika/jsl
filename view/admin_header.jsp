<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
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
 		<link rel = "stylesheet" href = "/Hongwaka/css/style.css">
 		<link href="css/font-awesome.css" rel="stylesheet"> 
		<link href='//fonts.googleapis.com/css?family=Montserrat:400,700' rel='stylesheet' type='text/css'>
		<link href='//fonts.googleapis.com/css?family=Noto+Sans:400,700' rel='stylesheet' type='text/css'>
	</head>
	<body>
	<div class = "header">
	<div class = "container">
		<div class = "logo">
			<h1><a href = "/Hongwaka/index.jsp"><b>T<br>H<br>E</b>&nbsp;Library<span>
			&nbsp;&nbsp;Hong-waka</span></a></h1>
		</div><br><br>
		<div class="nav-top">
			<div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
				<ul class = "nav navbar-nav ">
						<li class=" active"><a href="/Hongwaka/view/adminmain.jsp" class="hyper "><span>ホーム</span></a></li>
						<li class=" active"><a href="/Hongwaka/view/insertBook.jsp" class="hyper "><span>本の登録</span></a></li>
						<li class="active"><a href="/Hongwaka/view/modifyBook.jsp" class="hyper "><span>本の修正</span></a></li>
						<li class="active"><a href="/Hongwaka/view/deleteBook.jsp" class="hyper "><span>本の削除</span></a></li>
				</ul>
			</div>
		</div>
	</div>
	</div>
	<div class = "headerframe"></div>
          
      <c:if test="${message!=null}">
  		<script>
      	alert("${message}");
      	</script>
      </c:if>
	</body>
</html>