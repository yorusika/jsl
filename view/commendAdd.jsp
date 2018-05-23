<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<link href="https://fonts.googleapis.com/earlyaccess/hannari.css" rel="stylesheet" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<style>
		body{
	font-family:"Hannari";
	}
	:focus{outline: none;}
	
	#comment{border: 0; padding: 5px 0 7px; 
	border: 1px solid transparent; 
	border-bottom-color: #ccc; transition: 0.4s;}
	
	
	#comment:focus{padding: 5px 14px 7px; transition: 0.4s;}
	
	td{
	height: 100px;
	}
	
	#comment ~ .focus-border{position: absolute; height: 36px; bottom: 0; left: 0; width: 0; transition: 0.4s;}
	#comment:focus ~ .focus-border{width: 100%; transition: 1s; border: 2px solid #039445;}
	
	.col-3{float: left; width: 90%; margin: 40px 3%; position: relative;} /* necessary to give position: relative to parent. */
	input[type="text"]{font: 15px/24px "Hannari"; color: #333; width: 100%; letter-spacing: 1px; border:0px;}
	
	
	#submitbtn{
    border: 1px solid #00b336;
    background: #039445;
    font-size: 13px;
    font-weight: 700;
    line-height: 30px;
    color: #fff;
    cursor: pointer;
    	-webkit-box-shadow: 1.5px 1.5px 3px rgba(0, 0, 0, 0.2);
      box-shadow: 1.5px 1.5px 3px rgba(0, 0, 0, 0.2);
	}
	
	#submitbtn:hover{
	border: 1px solid #039445;
	background: #2C7C31;
	color: #fff;
	webkit-box-shadow:none;
	box-shadow:none;
	}
	</style>
</head>
<body>
<div align="center">
		
			
		<form action="commendAdd.hong?book_id=${finding_book.book_id }" method="post">
<!-- 			<table class="table "> -->
<!-- 			  <tr> -->
<!-- 				<th class="t-head head-it ">id</th> -->
<!-- 				<th class="t-head">내용</th>				 -->
<!-- 				<th class="t-head">입력</th> -->
				
<!-- 			  </tr> -->
			  
<!-- 			  <tr class="cross">			 -->
<%-- 				 <td class = "t-data">${finding_book.book_id }</td>				 --%>
<!-- 				<td class="t-data"><input type="text" name="comment"/></td>				 -->
<!-- 				<td class="t-data"><input type="submit" value="입력"/></td>			 -->
<!-- 			  </tr>			   -->
<!-- 			  </table> -->
			 
			<c:if test="${member.id==null}">
			<center><h4>コメントを投稿するにはログインが必要です。</h4></center>
			</c:if>
				  
			<c:if test="${member.id!=null}">				
			 <table width="700" border="0">
			  <tr>
			    <td width="150">${member.id}</td>
			    
			    <td><div class="col-3"><input type="text" name="comment" id="comment" maxlength="100" size="50"/>
			    <span class="focus-border"></span>
			    </div></td>
			      
			    
			    <td width="102"><input id ="submitbtn" type="submit" value="入力"/></td>
			  </tr>
			</table>
			</c:if>
				
	 		 </form>
	 		
		  
	</div>
	
	
</body>
</html>