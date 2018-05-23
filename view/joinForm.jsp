<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert title here</title>
        <script src="/Hongwaka/js/member.js"></script>
    </head>
    <body>
        <div>
               <%@ include file= "header.jsp"%> 
        </div>
        <div class="banner-top">
			<div class="container">
				<h3>会員登録</h3>
				<h4>
					<a href="/Hongwaka/index.jsp">ホーム</a><label>/</label>会員登録
				</h4>
				<div class="clearfix"></div>
			</div>
		</div>
        <div class="login">
            <div class="main-agileits">
                <div class="form-w3agile form1">
                    <h3>会員登録</h3>
                    <form action="/Hongwaka/join.hong" method="post" name = "frm" onsubmit="return joinCheck()">
                        <div class = "add add-4">
                        <input type="button" value="ID チェック" onclick="idCheck();" >
                        <input type="hidden" value="false" name="check">
                        </div>
                        <div class="key">
                            <i class="fa fa-user" aria-hidden="true"></i>
                            <input type="text" name="id" value = "ユーザーID" onfocus="this.value = '';inputIdChk()" onblur="if (this.value == '') {this.value = 'ユーザーID';}" />
                            <div class="clearfix">
                            </div>
                        </div>
                        <div class="key">
                            <i class="fa fa-lock" aria-hidden="true"></i>
                            <input type="password" name="pass" onfocus="this.value = '';" value = "暗証番号" />
                            <div class="clearfix"></div>
                        </div>
                        <div class="key">
                            <i class="fa fa-heart" aria-hidden="true"></i>
                            <input type="text" name="name" onfocus="this.value = '';" value = "名前" />
                            <div class="clearfix"></div>
                        </div>
                        <div class = "add add-3">
                        <input type="submit" value="登録">
                                                
                        </div>
                    </form>
                </div>
            </div>
        </div>
   
    </body>
    </html>