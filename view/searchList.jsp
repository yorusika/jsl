<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<style type="text/css">
        	
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
        	

		img{
				width:130px;
				height:200px;
				vertical-align:top;
				border:none;
			}
	</style>
</head>
<body>
		<div>
		<!-- 헤더 페이지  -->
			<%@ include file= "header.jsp"%>
		</div>
<form action="/Hongwaka/library.hong" method="post">
<div class="banner-top">
	<div class="container">
		<h3 >タイトル検索</h3>
		<h4><a href="index.jsp">ホーム</a><label>/</label>タイトル検索</h4>
		<div class="clearfix"> </div>
	</div>
</div>
<div class="content-top ">
                <div class="container ">
                    <div class="spec ">
                    
                        <!-- 문학/경제/어린이 등 입력 -->
                        <h3>『${search }』</h3>
                        <div class="ser-t">
                            <b></b>
                            <span><i></i></span>
                            <b class="line"></b>
                        </div>
                    </div>
</div>
<div class = "container">
	<h4><strong>『${search }』</strong>の検索結果:${paging.totalCount}件</h4>
	<c:choose>
	<c:when test="${searchList != null }">
	<div class = "wood">
	<table class="table ">
		  <tr>
			
			<th class="t-head head-it ">本</th>
			<th class="t-head">タイトル</th>
			<th class="t-head">著者</th>
		  </tr>
		  <c:forEach var = "book" items ="${searchList }" varStatus = "status">
		  <tr class="cross">
		
			<td class="ring-in t-data">
				<a href="showBook.hong?book_id=${book.book_id }" class="at-in">
					<img src="/Hongwaka/book_images/${book.image_name}" class="img-responsive" alt="${book.name }">
				</a>
			 </td>
			 <td class = "t-data">${book.name}</td>				
			<td class="t-data">${book.author }</td>
		  </tr>
		  </c:forEach>
		  		    <tr>
		  <td colspan="3">
		  	
                 <div class="pagingpro" style="text-align:center;">
                <c:if test="${paging.startPage>1}">
                <a href="/Hongwaka/search.hong?currentPage=${paging.startPage-1}&&search=${search}">&laquo</a>
                </c:if>
                	
				<c:forEach var="page" begin="${paging.startPage}" end="${paging.endPage}" step="1">
				
						<c:choose>
						<c:when test="${page == paging.currentPage}">
				 <a href="#"  onclick="return false;" class="active"> ${page} </a>
						</c:when>
						<c:otherwise>
						
				<a href="/Hongwaka/search.hong?currentPage=${page}&&search=${search}">${page}</a>
						
						</c:otherwise>
						</c:choose>
				</c:forEach>
				
				<c:if test="${paging.endPage<paging.totalPage}">
               <a href="/Hongwaka/search.hong?currentPage=${paging.endPage+1}&&search=${search}">&raquo;</a>
                </c:if>
             
     
          
		  </td>
		  </tr>
	</table>
	</div>
	</c:when>
	<c:otherwise>
		<br><br> 検索結果が存在しません。
	</c:otherwise>
	</c:choose>
	</div>
		  <br><br>
	</form>
</body>
</html>