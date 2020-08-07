<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 입력</title>
</head>
<body>
	<h3 align="center">게시글 입력</h3>
	<!-- boardtitle, boardcontent. boardattchment 입력 -->
	<div align="center">
		<form id="boardform" method="post" enctype="multipart/form-data">
			제목<input type="text" name="boardtitle" id="boardtitle" /><br />
			첨부파일<input type="file" name="boardattachment" id="boardattachment"/> <br/> 
			게시글<textarea cols="50" rows="30" name="boardcontent" id="boardcontent"></textarea><br />
		</form>
		<input type="button" value="글쓰기" id="boardwritebtn"/> 
		<input type="button" value="게시판 목록으로" id="listbtn" /> 
		<input type="button" value="메인으로" id="mainbtn" />
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/boardtbl/boardwrite.js"></script>
</html>