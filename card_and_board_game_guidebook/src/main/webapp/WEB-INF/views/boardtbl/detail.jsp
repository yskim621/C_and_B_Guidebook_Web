<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
	<h3 align="center">데이터 목록 보기</h3>
	<div align="center" id="board">
		<table align="center" border="1">
			<tr>
				<td>제목: &nbsp;${boardtbl.boardtitle}</td><br/>
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
				<textarea cols="50" rows="30" name="boardcontent" id="boardcontent">
				${boardtbl.boardcontent}</textarea>
				</td>
			</tr>
		</table>
		<input type="button" value="수정" id="updatebtn" name="updatebtn" /> 
		<input type="button" value="목록으로" id="listbtn" />
	</div>
</body>
<script>
	document.getElementById("listbtn").addEventListener("click", function() {
		location.href = "${pageContext.request.contextPath}/board/list";
	});
</script>
</html>