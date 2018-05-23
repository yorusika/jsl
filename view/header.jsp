<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <!DOCTYPE html>
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
          <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
          <!-- 일본어 폰트 -->
         
          <link href="https://fonts.googleapis.com/earlyaccess/hannari.css" rel="stylesheet" />
          
          <script src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
          <script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
          
      </head>
      <body>
 
          <div class="header">
              <div class="container">
                  <div class="logo">
                      <h1><a href="/Hongwaka/index.jsp"><b>T<br>H<br>E</b>&nbsp;Library<span>
				&nbsp;&nbsp;Hong-waka</span></a></h1>
                  </div><br><br>
                  <div class="nav-top">
                      <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                          <ul class="nav navbar-nav ">
                              <li class=" active"><a href="/Hongwaka/index.jsp" class="hyper "><span>ホーム</span></a></li>
                              <li class="active">
                                  <a href="#" class="dropdown-toggle hyper" data-toggle="dropdown"><span>ジャンル一覧<b class="caret"></b></span></a>
                                  <ul class="dropdown-menu multi">
                                      <li><a href="/Hongwaka/kindSearch.hong?kind=lit">文学</a></li>
                                      <li><a href="/Hongwaka/kindSearch.hong?kind=edu">教育</a></li>
                                      <li><a href="/Hongwaka/kindSearch.hong?kind=pol">政治</a></li>
                                      <li><a href="/Hongwaka/kindSearch.hong?kind=eco">経済</a></li>
                                      <li><a href="/Hongwaka/kindSearch.hong?kind=kid">児童</a></li>
                                  </ul>
                              </li>
                              <c:choose>
                           	<c:when test="${member.id==null}">
                           		<li class=" active"><a href="/Hongwaka/view/loginForm.jsp" class="hyper "><span>ログイン</span></a></li>
                          		<li class=" active"><a href="/Hongwaka/view/joinForm.jsp" class="hyper "><span>会員登録</span></a></li>
                          		</c:when>
                          		<c:otherwise>
                          			<li class=" active"><a href="/Hongwaka/logout.hong" class="hyper "><span>ログアウト</span></a></li>
                          			<li class=" active"><a href="/Hongwaka/remove.hong" class="hyper "><span>退会</span></a></li>
                          			 <li class=" active"><a href="/Hongwaka/library.hong" class="hyper "><span>マイ本棚</span></a></li>
                          		</c:otherwise>		                         	
                          	</c:choose>                          	
<!--                             <li class=" active"><a href="/Hongwaka/library.hong" class="hyper "><span>My Bookshelf</span></a></li> -->
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

      </body>
      </html>