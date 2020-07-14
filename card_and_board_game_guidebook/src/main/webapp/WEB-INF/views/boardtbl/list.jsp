<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>서비스 개선 건의사항</title>
</head>
<body>
	<h3 align="center">서비스 개선 건의사항</h3>
	<div align="center" id="board">
		<table align="center" border="1">
			<tr>
				<th>게시글 번호</th>
				<th>제목</th>
				<th>작성일</th>
				<th>조회수</th>
				<th>작성자</th>
			</tr>
			<c:forEach var="boardtbl" items="${list}">
				<tr>
					<td align="center">&nbsp;${boardtbl.boardnum}</td>
					<td>
					<a href="detail/${boardtbl.boardnum}">&nbsp;${boardtbl.boardtitle}</a>
					</td>
					<td>&nbsp;${boardtbl.boardwritedate}</td>
					<td>&nbsp;${boardtbl.boardreadcnt}</td>
					<td>&nbsp;${boardtbl.membernickname}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="button" value="글쓰기" id="boardwrite" name="boardwrite" />
		<input type="button" value="메인으로" id="mainbtn"/>
	</div>
</body>
<script>
	document.getElementById("boardwrite").addEventListener("click", function(){
		location="${pageContext.request.contextPath}/board/write";
	});
	document.getElementById("mainbtn").addEventListener("click", function() {
		location.href = "${pageContext.request.contextPath}/";
	});
</script>
</html>