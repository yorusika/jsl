<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		<style type="text/css">
        img{
         width:100px;
         height:200px;
         vertical-align:top;
         border:0;
      }
      
      

        	
        	.pagingpro {
   			 display: inline-block;
   			 text-align:center;

			}

.pagingpro a {
    color: white;
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
        	
      </style>
	</head>
	<body>
		<div>
		<%@ include file = "header.jsp" %>
		</div>
		

		<div class="banner-top">
	<div class="container">
		<h3 >マイ本棚</h3>
		<h4><a href="index.jsp">ホーム</a><label>/</label>マイ本棚</h4>
		<div class="clearfix"> </div>
	</div>
</div>
		<div class="content-top ">
                <div class="container ">
                    <div class="spec ">
                    
                        <!-- 문학/경제/어린이 등 입력 -->
                        <h3>${member.name}様の本棚</h3>
                        <div class="ser-t">
                            <b></b>
                            <span><i></i></span>
                            <b class="line"></b>
                        </div>
                    </div>
		</div>
		</div>
		</div>
		<div class = "container">
		<c:choose>
		<c:when test="${paging.totalCount<16}">
		<h4>後${20-paging.totalCount}冊までお借りいただけます<font style="color:#039445">(${paging.totalCount}/20)</fotn> </h4>
		</c:when>
		<c:when test="${paging.totalCount>=16&&paging.totalCount<20}">
		<h4>後${20-paging.totalCount}冊までお借りいただけます<font style="color:#FF9600">(${paging.totalCount}/20)</fotn> </h4>
		</c:when>
		<c:otherwise>
		<h4>次の本をお借りになるために、お借りになった本をお返しになる必要があります。<font style="color:red;">(${paging.totalCount}/20) </font></h4>
		</c:otherwise>
		</c:choose>
		  <div class = "wood">

		
<%-- 		<c:forEach var="newbook" begin="1" end="${libraryList.size()}" step="1"> --%>
		
				<table class="table ">
		  <tr>
			<th class="t-head head-it "><h4>本</h4></th>
			<th class="t-head"><h4>タイトル</h4></th>
			<th class="t-head"><h4>著者</h4></th>
			<th class = "t-head" ><h4> 返却</h4> </th>
		  </tr>
		  			<c:forEach var="Book" items="${libraryList }" varStatus="status">
		  <tr class="cross">
			<td class="ring-in t-data">
				<a href="showBook.hong?book_id=${Book.book_id }" class="at-in">
<!-- 					<img src="./book_images/book_sample01.jpg" class="img-responsive" alt=""> -->
<%-- 					<img src="/Hongwaka/book_images/${libraryList.get(0).getImage_name()}" class="img-responsive" alt=""> --%>
						<img src="/Hongwaka/book_images/${Book.image_name}" class="img-responsive" alt="">
				</a>
			 </td>
			 <td class = "t-data"><h4>${Book.name}</h4></td>				
			<td class="t-data"><h4>${Book.author}</h4></td>
			<td class="t-data"><a class=" add-1" href="/Hongwaka/shelfDelete.hong?book_id=${Book.book_id}">返却</a></td>			
		  </tr>

		   </c:forEach>
		    <tr>
		  <td colspan="4">
		  	
                 <div class="pagingpro" style="text-align:center;">
                <c:if test="${paging.startPage>1}">
                <a href="/Hongwaka/library.hong?currentPage=${paging.startPage-1}">&laquo</a>
                </c:if>
                	
				<c:forEach var="page" begin="${paging.startPage}" end="${paging.endPage}" step="1">
				
						<c:choose>
						<c:when test="${page == paging.currentPage}">
				 <a href="#"  onclick="return false;" class="active"> ${page} </a>
						</c:when>
						<c:otherwise>
						
				<a href="/Hongwaka/library.hong?currentPage=${page}">${page}</a>
						
						</c:otherwise>
						</c:choose>
				</c:forEach>
				
				<c:if test="${paging.endPage<paging.totalPage}">
               <a href="/Hongwaka/library.hong?currentPage=${paging.endPage+1}">&raquo;</a>
                </c:if>
             
     
          
		  </td>
		  </tr>
		  </table>
 		 
		       
<!-- 		  <c:if test = "${libraryList==null }">
< 				등록된 상품이 없단다! 
			</c:if> -->
		  
		  
	</div>
	

	</body>
</html>