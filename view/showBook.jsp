<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type= text/javascript>
	function rent_book() {
		var book_id=${finding_book.book_id };
	
		$.ajax({
			url:"/Hongwaka/rent",
			type:"post",
			data: {book_id:book_id},
		success: function(result){
			//성공했다면
			if(result == "success"){
				
				$("#rent_book").hide();
				$("#return_book").show();
				$("#viewer").show();
			}else{	//실패했다면 에러메세지
				alert(result);
			}
		}
		})

	}
	
	function return_book() {
		var book_id=${finding_book.book_id };
		$.ajax({
			url:"/Hongwaka/return_book",
			type:"post",
			data: {book_id:book_id},
		success: function(result){
			//성공했다면
			if(result == "success"){
				$("#rent_book").show();
				$("#return_book").hide();
				$("#viewer").hide();
			}else{	//실패했다면 에러메세지
				alert(result);
			}
		}
		})

	}
	


</script>
</head>
<body>
            <div>
                <%@ include file = "header.jsp" %>
            </div>
            <div class="banner-top">
                <div class="container">
                    <h4>詳細情報</h4>
                    <h4><a href="/Hongwaka/index.jsp">ホーム</a><label>/</label>${search }</h4>
                    <div class="clearfix"> </div>
                </div>
            </div>

<div class= "container">
	<div class="single">
			<div class="container">
						<div class="single-top-main">
	   		<div class="col-md-5 single-top">
	   		<div class="single-w3agile">
							
<div id="picture-frame">
			<img src="/Hongwaka/book_images/${finding_book.image_name }" data-src="/Hongwaka/book_images/${finding_book.image_name }" alt="${finding_book.name }" class="img-responsive"/>
		</div>
			<script src="js/jquery.zoomtoo.js"></script>
			<script>
				$(function() {
					$("#picture-frame").zoomToo({
						magnify: 1
					});
				});
			</script>
			</div>
		
		<div class="add add-3">
		<c:if test="${sessionScope.member!=null }">
	  				<button id="rent_book" class="btn btn-danger my-cart-btn my-cart-b" data-image="images/si.jpg" onclick="rent_book()">
										   貸出</button>
					<button id="return_book" class="btn btn-danger my-cart-btn my-cart-b" data-image="images/si.jpg" onclick="return_book()">
										  返却</button>
					<button id="viewer" onclick="location.href='/Hongwaka/getPages.hong?book_id=${finding_book.book_id}'" id="return_book" class="btn btn-danger my-cart-btn my-cart-b" data-image="images/si.jpg"><i class="material-icons">import_contacts</i></button>
		<c:choose>
		<c:when test="${finding_book.isRent == 0}">
				<script>
				 $("#return_book").hide();
				 $("#viewer").hide();
				</script>	

		</c:when>
		<c:otherwise>
				<script>
				 $("#rent_book").hide();
				</script>
		</c:otherwise>

		</c:choose>
		
		
		
		</c:if>
										</div><br><br>
	
			</div>
		
			<div class="col-md-7 single-top-left ">
								<div class="single-right">
				<h3>${finding_book.name }</h3><br>
				<h5>${finding_book.author }</h5>
				 <div class="pr-single">
					
				</div>
				<p class="in-pa"><h5><strong>目次</strong></h5>
					${finding_book.list }<br><hr>
				<h5><strong>紹介</strong></h5>
					${finding_book.introduce }<br><hr>
				<h5><strong>著者紹介</strong></h5>
					${finding_book.author_introduce }<hr>  </p>


			
			<div class="clearfix"><br><br><br> </div>
			</div>
			</div>
		   <div class="clearfix"> </div>
	   </div>	
				</div>
	</div>
</div>

<div class = "add add-3">			
			<%@ include file="/view/commendAdd.jsp"%>
			<%-- <iframe  width="800" height="300" src="commendAdd.hong?book_id=${finding_book.book_id }" frameborder = "0"  >
			</iframe> --%>
		</div>
		
<div class = "add add-3">
		<iframe  width="1000" height="1000" src="commendRead.hong?book_id=${finding_book.book_id }" frameborder = "0"  >
			</iframe>
</div>

</body>
</html>