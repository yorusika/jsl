/**
 * 
 */

function filecheck(){
	if(!document.admin.image_name.value || document.admin.image_name.value==""){
		alert("イメージを入れてください。");
		document.admin.image_name.focus();
		return false;
	}
	var filename=document.admin.image_name.value;
	fileName = filename.slice(filename.indexOf(".") + 1).toLowerCase();


	if(fileName != "jpg" && fileName != "png" &&  fileName != "gif"){

		alert("jpg, png, gifファイルのみ登録できます。");

		document.admin.image_name.value="";
		document.admin.image_name.focus();
		
		return false;

		}
	
}


function modifycheck(){
	
	var filename=document.modify.image_name.value;
	fileName = filename.slice(filename.indexOf(".") + 1).toLowerCase();
	

	if(fileName!=null && fileName!="" && fileName != "jpg" && fileName != "png" &&  fileName != "gif"){

		alert("jpg, png, gifファイルの登録できます。");
		
		document.modify.image_name.value=null;
		document.modify.image_name.focus();
		
		return false;

		}
	
}