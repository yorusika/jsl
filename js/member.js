


function idCheck(){
if(document.frm.id.value == '' ||document.frm.id.value=="ユーザーID"){
alert('IDを入力してください。');
document.frm.id.focus();
return;
}
var url="/Hongwaka/idCheck.hong?id="+document.frm.id.value;
window.open(url,"_blank",
"toolbar=no, menubar=no, scrollbars=yes, resizable=no, width=900, height=300");
}


function idok(){
opener.document.frm.check.value="true";
window.close();
}

function inputIdChk(){
	document.frm.check.value="false";
}


function joinCheck(){
	if(document.frm.id.value == '' || document.frm.id.value == "ユーザーID"){
		alert("IDを入力してください。");
		return false;
	}
	
	var idCheck=/^[a-zA-Z0-9]{4,10}$/;
	if(!idCheck.test(document.frm.id.value)){
		alert("IDは4文字から10文字まで、英文字と数字のみお使いになれます。");
		return false;
	}
	
	
	
	if(document.frm.pass.value==''||document.frm.pass.value=="暗証番号"){
		alert("暗証番号を入力してください。");
		return false;
	}
	
	
	var passCheck=/^[a-zA-Z0-9]{4,15}$/;
	if(!passCheck.test(document.frm.pass.value)){
		alert("暗証番号は4文字から15文字まで、英文字と数字のみお使いになれます。");
		return false;
	}
	
	if(document.frm.name.value==''||document.frm.name.value=="名前"){
		alert("名前を入力してください。");
		return false;
	}
	
	if(document.frm.name.value.length>10){
		alert("名前は10字を超えません。");
		return false;
	}
	
	if(document.frm.check.value=="false"){
		alert("idをチェックしてください。");
		return false;
	}
	}


	