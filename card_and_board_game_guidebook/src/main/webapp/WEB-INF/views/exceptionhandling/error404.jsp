<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- exception 객체를 사용할 수 있도록 설정 -->    
<%@ page isErrorPage="true" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>404 에러 메시지 페이지</title>

<style>
 #error404 {
 	width: 60em;
 	height: 40em;
 }
</style>
</head>
<body>
	<h1 align = "center">◆잘못된 URL 입니다. 다시 URL을 확인하시길 바랍니다◆</h1>
	<h2 align = "center">메인 페이지로 이동하시려면 이미지를 클릭하세요.</h2>
	<div align = "center" >
	<a href ="${pageContext.request.contextPath}/"><img src="${pageContext.request.contextPath}/resources/images/404_error_page.jpg"  id = "error404"/></a>
	</div>
</body>
</html>