<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html>

        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>idチェック</title>
            <script src="${pageContext.request.contextPath}/js/member.js"></script>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.css">
            <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
        </head>

        <body>
        <div class = "login">
        <div class = "main-agileits">
        	<div class = "form-w3agile">
            <h2>idチェック</h2>
            <form action="idCheck.hong" method="post" name="frm">
            <%--  아이디 : <input type="text" name="id" value="${id}">  --%>
                <br>
               <c:if test="${result==0}">
                      	『${id}』はすでに使用されております。
                </c:if> 
                
                <c:if test="${result==-1}">
                    	『${id}』はご利用になれます。
                    <input type="button" value="このIDを使用" class="cancel" onclick="idok()">
                </c:if>
            </form>
            </div>
            </div>
         </div>
        </body>
        </html>