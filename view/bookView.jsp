<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

	
	<head>
	<!-- 제이쿼리 임포트 -->
	 <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
	<!-- turn.js 임포트 -->
	<script src="./js/turn.min.js"></script>
	
	<!--아이콘 폰트-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/fonts/flaticon.css"> 
	<!-- 구글 아이콘 임포트 -->
	<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
	<link href="https://fonts.googleapis.com/earlyaccess/sawarabimincho.css" rel="stylesheet" />
	
     <!-- 글씨체 import -->
     <link href="https://fonts.googleapis.com/earlyaccess/hannari.css" rel="stylesheet" />
     <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bookView.css">

			<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
		
		
		<script type="text/javascript">
			var tog=0;
		    var book_mark="${book_view.book_mark}";
			var book_folder="${book_view.book_folder}";
			var book_page=Number("${book_view.book_page}");
			var book_id="${book_view.book_id}";
			
			
			$(document).ready(function(){
				$("#day").hide();
				$("#siori").hide();
				$("#book").turn({pages:book_page});
				
				$("#book").bind('turning',
						function(event, page, obj){
					$("#siori").hide();
					  var range = $(this).turn('range', page);
					  for (page = range[0]; page<=range[1]; page++)
						    addPage(page, $(this));
						
							
					});
					
				if(book_mark>0){
					$('#book').turn('page', book_mark);
					$("#siori").show();
				}
				
					
			$("#book").bind('turned',
						function(event, page, obj){
			var current_page=$("#book").turn('page');
			var mark_page=book_mark;
			
			if(current_page%2!=0){
			current_page-=1;
			}
			
			if(mark_page%2!=0){
			mark_page-=1;
			}
						
			if(current_page==mark_page&&mark_page>0){
			$("#siori").show();
			
			}
			
			});
				
			$('#day').click(function() {
			
			
			$("#night").show();
			$("#day").hide();
			
			$(".page").css("background-color", "#F1F6F8");
	    	$(".page").css("color", "#000000");
	    	
	    	$("body").css("background", 'linear-gradient(-45deg, rgba(187, 222, 251, .9), rgba(255, 255, 255, .9)) fixed, url("./book_images/sea.jpg") fixed');
	    	$("body").css("background-size", '100%');
				    	
	    	$(".marker").css("color", "black");
	    	$(".title").css("color", "black");
				    	
	    	$("#book").bind('turning',
	    	function(event, page, obj){
	   		$(".page").css("background-color", "#F1F6F8");
			$(".page").css("color", "#000000");
			});
			
			});
			
			
			$('#night').click(function() {
			$("#day").show();
			$("#night").hide();
			
		   	$(".page").css("background-color", "#263238");
	    	$(".page").css("color", "#FFFFFF");
				    	
	    	$("body").css("background", 'linear-gradient(-45deg, rgba(55, 71, 79, .9), rgba(0, 0, 0, .9)) fixed, url("./book_images/dark.jpg") fixed');
	    	$("body").css("background-size", '100%');
				    	
	    	$(".marker").css("color", "white");
	    	$(".title").css("color", "white");
				    	
	    	$("#book").bind('turning',
	    	function(event, page, obj){
    		$(".page").css("background-color", "#263238");
    		$(".page").css("color", "#FFFFFF");
    		});
			
			})
			
				
				$("#canvas").dblclick(function(){
					if(tog==0){
				    $("#canvas").css("transform", "scale(1.5)");
					tog=1;
					}else{
					$("#canvas").css("transform", "none");
						tog=0;
					}
				});
				
			$("#marker").click(function(){
				if($("#book").turn('page')>1&&$("#book").turn('page')<book_page){
				$.ajax({
     				url:"/Hongwaka/book_mark",
     				type:"post",
     				data: {book_mark:$("#book").turn('page'), book_id:book_id},
     			success: function(result){
     				//성공했다면
     				$("#siori").show();
     				book_mark=$("#book").turn('page');
     				
     			}
     			});
     			}else{
     			
     			alert("表紙にはしおりを挟めません。");
     			}
     			
     			
				
			});
			
			
			$("#marker_remove").click(function(){
				$.ajax({
     				url:"/Hongwaka/book_mark",
     				type:"post",
     				data: {book_mark:"0", book_id:book_id},
     			success: function(result){
     				//성공했다면
     				$("#siori").hide();
     				book_mark=0;
     				
     			}
     			});
	
			});
			
			$("#marker_view").click(function(){
				$('#book').turn('page', book_mark);
				$("#siori").show();
			});
				
				
			});
				
				
				
				$(document).keydown(function(e){

					var previous = 37, next = 39;

					switch (e.keyCode) {
						case previous:

							$('#book').turn('previous');

						break;
						case next:
							
							$('#book').turn('next');

						break;
					}
			});

				function addPage(page, book) {
				
					   // Check if the page is not in the book
					  if (!book.turn('hasPage', page)) {
					    // Create an element for this page
						  /*var element = $('<div />').html('Loading…');*/
						  var element = $('<div />').html('Loading…');
						    // Add the page
						    book.turn('addPage', element, page);
						    // Get the data for this page	
						    
						    	 element.load("./book/"+book_folder+"/"+(page-2)+".html");

						       /*element.html(data);*/
						     
						  
					   }
					
				}
				

		</script>
	

	




		
		
		
	</head>
	<body>
		
		<div class="box">
			
			<div class="wrapper">
				
				<div class ="title" align="center"><a>${book_view.name}</a></div>
				
				<div class="marker">
				<span class="flaticon-arrows" onclick="javascript:history.back();"></span>
				<span id="marker_view" class="flaticon-open-book"></span>
				<span id="marker" class="flaticon-shapes-1"></span>
				<span id="marker_remove" class="flaticon-shapes"></span>&nbsp;
				<span id="day" class="material-icons">brightness_low</span>
				<span id="night" class="material-icons">brightness_medium</span>
				</div>
				
				
			
			  </div>
			 	
		
			
		


		<div id="canvas">
				<div id="siori">
				<img src="./book_images/siori.png" width="50px" height="70px">
				</div>
			<div id="book">
				<div class="hard" style="background-image:url(./book/${book_view.book_folder}/Front.jpg)"></div>
				<div class="hard front-side" style="background-color: #F1F6F8; background-size:0.7%; background-position:right top;">
					<image src="./book/${book_view.book_folder}/FrontSide.jpg" width=300px height=700px style="box-shadow: 0 4px 10px #666;">
				</div>
				<div class="hard back-side p${book_view.book_page-1}" style="background-color: #F1F6F8; background-size:0.7%; background-position:left top;">
					<image src="./book/${book_view.book_folder}/BackSide.jpg" width=300px height=700px align=right style="box-shadow: 0 4px 10px #666;">
				</div>
				<div class="hard p${book_view.book_page}" style="background-image:url(./book/${book_view.book_folder}/Back.jpg)" ></div>
			</div>	
	</div>
</div>
	



</body>
	</body>
</html>