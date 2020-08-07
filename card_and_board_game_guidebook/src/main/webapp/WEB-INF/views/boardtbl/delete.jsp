<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 삭제</title>
</head>
<body>
	<h3 align="center">게시글 삭제</h3>
	<div align="center">
		<form id="boardform" method="post">
			게시글 번호를 입력하세요: <input type="text" name="boardnum" id="boardnum" /><br />
		</form>
		<input type="button" value="삭제" id="boarddeletebtn"/>
		<input type="button" value="삭제 취소" id="boarddeletecancelbtn"/> 
		<input type="button" value="게시판 목록으로" id="listbtn" /> 
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/boardtbl/boarddelete.js"></script>
</html>