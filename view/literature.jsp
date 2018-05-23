<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
        	<style>
        	.box{
        	position:absolute;width:100%;height:100%;text-align:center;
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
        	</style>
        
        
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Insert title here</title>
     		 <!-- 책 정보를 ajax로 보내고 받아온 결과에 따라 대여중 or 에러메세지 출력 -->
     		 <script type="text/javascript">
     		 function rent_book(index, book_id){
     			$.ajax({
     				url:"/Hongwaka/rent",
     				type:"post",
     				data: {book_id:book_id},
     			success: function(result){
     				//성공했다면
     				if(result == "success"){
     					
     					 $(".rent_book:eq("+index+")").html("<div class='btn btn-danger my-cart-btn my-cart-c'>貸出中</div>");
     					 
     				}else{	//실패했다면 에러메세지
     					alert(result);
     				}
     			}
     			})
     			 
     			return false;
     			 
     		 }
     		 </script>
        </head>

        <body>
            <div>
                <%@ include file = "header.jsp" %>
            </div>


        <div class="banner-top">
			<div class="container">
				<h3>${search }</h3>
				<h4>
					<a href="/Hongwaka/index.jsp">ホーム</a><label>/</label>${search }
				</h4>
				<div class="clearfix"></div>
			</div>
		</div>
				



            <div class="content-top ">
			
                <div class="container ">
                    <div class="spec ">
                    
                        <!-- 문학/경제/어린이 등 입력 -->
                        <h3>${search }</h3>
                        <div class="ser-t">
                            <b></b>
                            <span><i></i></span>
                            <b class="line"></b>
                        </div>
                    </div>

                    <!-- 이 아래부터  -->
                    <c:forEach var="Book" items="${searchList}" varStatus="status">
	                   <%--  <c:if test="varStatus==4">
	                    	<br>
	                    </c:if> --%>
                        <div class="tab-head ">
                            <div class=" tab-content tab-content-t ">
                                <div class="tab-pane active text-style" id="tab1">
                                    <div class=" con-w3l">

                                        <div class="col-md-3 m-wthree">
                                            <div class="col-m">
                                                <!--<a href="/Hongwaka/view/joinForm.jsp" data-toggle="modal" data-target="#myModal1" class="offer-img"> -->
                                                <a href="/Hongwaka/showBook.hong?book_id=${Book.book_id}" data-toggle="modal" class="offer-img">
											<img src="/Hongwaka/book_images/${Book.image_name}" class="img-responsive" alt="">
											<div class = "add add-3"><h4>${Book.name }</h4></div>
											</a>
                                                <div class="mid-1">
                                                    <div class="add">
													<c:if test="${sessionScope.member!=null }">
	  											
										   			
													<c:choose>
													
														<c:when test="${Book.isRent == 0}">
														<div class="rent_book"> 
														<button class="btn btn-danger my-cart-btn my-cart-b" data-image="images/si.jpg" onclick="rent_book('${status.index}', '${Book.book_id }' )">
												   				貸出</button>
												   		
														</div>
												</c:when>
												<c:otherwise>
												<div class="rent_book"> 
												<div class="btn btn-danger my-cart-btn my-cart-c">貸出中</div>
												</div>
												</c:otherwise>

												</c:choose>
		
		
		
											</c:if>		
                                                    </div>

                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
          			    </c:forEach>
          			    
          			    
					
                    <!-- 여기까지가 목록화면 -->
                
                </div>
                   
        	<div class="box">
                 <div class="pagingpro" style="text-align:center;">
                <c:if test="${paging.startPage>1}">
                <a href="/Hongwaka/kindSearch.hong?kind=${kind}&&currentPage=${paging.startPage-1}">&laquo</a>
                </c:if>
                	
				<c:forEach var="page" begin="${paging.startPage}" end="${paging.endPage}" step="1">
				
						<c:choose>
						<c:when test="${page == paging.currentPage}">
				 <a href="#"  onclick="return false;" class="active"> ${page} </a>
						</c:when>
						<c:otherwise>
						
				<a href="/Hongwaka/kindSearch.hong?kind=${kind}&&currentPage=${page}">${page}</a>
						
						</c:otherwise>
						</c:choose>
				</c:forEach>
				
				<c:if test="${paging.endPage<paging.totalPage}">
               <a href="/Hongwaka/kindSearch.hong?kind=${kind}&&currentPage=${paging.endPage+1}">&raquo;</a>
                </c:if>
             
     
            </div>
    	</div>
 
        </body>

        </html>