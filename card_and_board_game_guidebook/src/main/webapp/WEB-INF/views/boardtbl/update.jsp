<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
	<h3 align="center">게시글 수정</h3>
	<div align="center" id="board">
		<form>
				<input type="text" value="${boardtbl.boardtitle}" name="boardtitle" id="boardtitle" size="30"/><br/>
				<textarea cols="50" rows="30" name="boardcontent" id="boardcontent">${boardtbl.boardcontent}</textarea>
		</form>
		<input type="button" value="수정 취소" id="cancelupdatebtn" name="cancelupdatebtn" /> 
		<input type="button" value="목록으로" id="listbtn" />
	</div>
</body>
<script>
	document.getElementById("cancelupdatebtn").addEventListener("click", function() {
		location.href = "${pageContext.request.contextPath}/board/detail/{boardnum}";
	});
	document.getElementById("listbtn").addEventListener("click", function() {
		location.href = "${pageContext.request.contextPath}/board/list";
	});
</script>
</html>