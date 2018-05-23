<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="https://fonts.googleapis.com/earlyaccess/hannari.css" rel="stylesheet" />
 <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<style>
	        	.box{
        	position:absolute;width:100%;height:100px;text-align:center;
        	padding-top:10px;
        	}
        	
        	.pagingpro {
   			 display: inline-block;
   			 text-align:center;

			}

	.pagingpro a {
    color: black;
    float: left;
    padding: 8px 16px;
    text-decoration: none;
    transition: background-color .3s;
    border: 1px solid #ddd;
    margin: 0 4px;
    
	}

	.pagingpro a.active {
    background-color: #4CAF50;
    color: white;
    border: 1px solid #4CAF50;
	}


	.pagingpro a:hover:not(.active) {background-color: #ddd;}
	
	body{
	font-family:"Hannari";
	}
	table{
	border-spacing:0px; border-style:none; padding:0px;
	  
	}
	td{
	border-spacing:0px; border-style:none; padding:0px;
	height:100px;
	
	}
	tr:first-child td:first-child { border-top-left-radius: 10px; }
	tr:first-child td:last-child { border-top-right-radius: 10px; }
	tr:last-child td:first-child { border-bottom-left-radius: 10px; }
	tr:last-child td:last-child { border-bottom-right-radius: 10px; }
	

	
	.mod0{
	color: #039445;
	background-color: white;
	border: none;
	}
	.mod0 a{
	color: #039445;
	}	
	.mod1{
	color: black;
	background-color: #4CAF50;
	border: none;
	
	}
	
	.mod1 a{
	color: black;
	}

	</style>
<title>Insert title here</title>
</head>
<body>
<!-- 댓글란 -->
	<div>	
	
	<c:if test="${commendList==null }">
	<center> 
	<table width="900">
	<tr>
		<td class="mod1">
		<center> 投稿されたコメントがありません。</center>
		</td>
	</table>
	</center>
	</c:if>
	<c:if test="${commendList!=null }">
		<c:forEach var="Book" items="${commendList }" varStatus="status">
			 <%--  <table class="table ">
			  <tr>
				<th class="t-head head-it ">id</th>
				<th class="t-head">내용</th>
				<th class="t-head">입력 날짜</th>
				<th class="t-head">${Book.getComment_id()}</th>
				
			  </tr>
			  
			  <tr class="cross">			
				 <td class = "t-data">${Book.id }</td>				
				<td class="t-data">${Book.comment}</td>
				<td class="t-data">${Book.date}</td>
				<td class="t-data"><a class=" add-1" href="commendDelete.hong?comment_id=${Book.getComment_id()}&&book_id=${Book.book_id }" target="_parent">Delete</a></td>			
			  </tr>			  
			  </table> --%>
			  
			  <center>
			  <table width="900">
			  <tr>
			  	<c:choose>
			  	<c:when test="${status.index%2==0}">
			    <td class="mod1" width="150">${Book.id }</td>
			    <td class="mod1" width="432">${Book.comment}</td>
			    <td class="mod1" width="188">${Book.date}</td>
			     <td class="mod1" width="20">
			    <c:if test="${member.id eq Book.id}">
				 <a href="commendDelete.hong?comment_id=${Book.getComment_id()}&&book_id=${Book.book_id }" target="_parent"><i class="material-icons">clear</i></a>
			    </c:if>
			    </td>
			    </c:when>
			    <c:otherwise>
			    <td class="mod0" width="150">${Book.id }</td>
			    <td class="mod0" width="432">${Book.comment}</td>
			    <td class="mod0" width="188">${Book.date}</td>
			     <td class="mod0" width="20">
			    <c:if test="${member.id eq Book.id}">
			   <a href="commendDelete.hong?comment_id=${Book.getComment_id()}&&book_id=${Book.book_id }" target="_parent"><i class="material-icons">clear</i></a>
			    </c:if>
			    </td>
			    </c:otherwise>
			    </c:choose>
			  </tr>
			</table>
			</center>
			  
	 		  </c:forEach>
	 		  </c:if>
	 		


        	<div class="box">
                 <div class="pagingpro" style="text-align:center;">
                <c:if test="${paging.startPage>1}">
                <a href="/Hongwaka/commendRead.hong?book_id=${book_id }&&currentPage=${paging.startPage-1}">&laquo</a>
                </c:if>
                	
				<c:forEach var="page" begin="${paging.startPage}" end="${paging.endPage}" step="1">
				
						<c:choose>
						<c:when test="${page == paging.currentPage}">
				 <a href="#"  onclick="return false;" class="active"> ${page} </a>
						</c:when>
						<c:otherwise>
						
				<a href="/Hongwaka/commendRead.hong?book_id=${book_id }&&currentPage=${page}">${page}</a>
						
						</c:otherwise>
						</c:choose>
				</c:forEach>
				
				<c:if test="${paging.endPage<paging.totalPage}">
               <a href="/Hongwaka/commendRead.hong?book_id=${book_id }&&currentPage=${paging.endPage+1}">&raquo;</a>
                </c:if>
             
     
            </div>
    	</div>


	</div>

</body>
</html>