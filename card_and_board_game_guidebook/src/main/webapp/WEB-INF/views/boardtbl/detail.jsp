<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
	<h3 align="center">게시글 보기</h3>
	<div align="center" id="board">
		<form id="boardform" name="${boardtbl.boardnum}">
		<table border="1" id="boardform">
			<tr>
				<td>제목: &nbsp;${boardtbl.boardtitle}</td>
			</tr>
			<tr>	
				<td>
				&nbsp;${boardtbl.membernickname}<br/>
				&nbsp;${boardtbl.boardwritedate}
				&nbsp;	조회수:${boardtbl.boardreadcnt}
				</td>
			</tr>
			<tr>
				<td>&nbsp;${boardtbl.boardattachment}</td>
			</tr>
			<tr>
				<td>
				<textarea cols="50" rows="30" name="boardcontent" id="boardcontent">${boardtbl.boardcontent}</textarea>
				</td>
			</tr>
		</table>
		<a href="../alter/${boardtbl.boardnum}"><input type="button" value="수정" id="updatebtn" name="updatebtn" /></a>
		<input type="button" value="목록으로" id="listbtn" />
		</form>
	</div>
</body>
<!-- <script src="${pageContext.request.contextPath}/js/boardtbl/boarddetail.js"></script> -->
<script>
	document.getElementById("listbtn").addEventListener("click", function() {
		location.href = "${pageContext.request.contextPath}/board/list";
	});
</script>
</html>