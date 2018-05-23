var num = 0; // 보여지는 프레임의 번호 0 or 1
var colWidth = -150;			
var numb = 0; // 보여지는 프레임의 번호 0 or 1
 var colWidthb = -150;
 function moveBannerb(whichBtn){
    var myListb = document.getElementById("bannerListb");
 
    if(whichBtn == 'leftBtn'){ //왼쪽버튼을 클릭했다면
       numb--;
       if(numb < 0) numb = 0;
       var xPos = numb * colWidthb;
       myListb.style.left = xPos+"px";
    }else{
       numb++;
       if(numb > 5) numb = 5;
       var xPos = numb*colWidthb;
       myListb.style.left = xPos + "px";
       
    }
 }

function moveBanner(whichBtn){
	var myList = document.getElementById("bannerList");

	if(whichBtn == 'leftBtn'){ //왼쪽버튼을 클릭했다면
		num--;
		if(num < 0) num = 0;
		var xPos = num * colWidth;
		myList.style.left = xPos+"px";
	}else{
		num++;
		if(num > 5) num = 5;
		var xPos = num*colWidth;
		myList.style.left = xPos + "px";
	}
}


