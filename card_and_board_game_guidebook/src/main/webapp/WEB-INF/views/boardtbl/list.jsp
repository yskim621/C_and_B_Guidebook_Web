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
	</div>
	<div align = "center">
		<c:if test="${prev == true}">
			<a href="list?no=${startpage-1}">이전</a>
		</c:if>
		
		<c:forEach var="idx" begin="${startpage}" end="${endpage}">
			<c:if test="${pageno == idx}">
				${pageno}&nbsp;
			</c:if>
			<c:if test="${pageno != idx}">
				<a href="list?no=${idx}">${idx}</a>&nbsp;
			</c:if>
		</c:forEach>
		
		<c:if test="${next == true}">
			<a href="list?no=${endpage+1}">다음</a>
		</c:if>
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/boardtbl/boardlist.js"></script>
</html>