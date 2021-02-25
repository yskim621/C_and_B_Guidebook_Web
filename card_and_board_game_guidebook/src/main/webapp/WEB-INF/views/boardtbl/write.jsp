<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 에러가 발생한 경우 보여질 페이지 설정 -->
<%@ page errorPage="${pageContext.request.contextPath}/WEB-INF/views/exceptionhandling/error404.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>서비스 개선 건의사항</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/board.css"/>
</head>
<body>
	<div id="page-wrapper">

		<!-- Header -->
		<section id="header">
			<div class="container">
				<div class="row">
					<div class="col-12">

						<!-- Logo -->
						<h1>
							<a href="${pageContext.request.contextPath}/" id="logo">C & B Guidebook</a>
						</h1>

						<!-- Nav -->
						<nav id="nav">
							
							<a href="${pageContext.request.contextPath}/game/trumpcard">트럼프 카드</a> 
							<a href="${pageContext.request.contextPath}/game/hwatu"> 화투</a> 
							<a href="${pageContext.request.contextPath}/game/boardgame">보드게임</a> 
							<a href="${pageContext.request.contextPath}/board">게시판</a>
							<a href="${pageContext.request.contextPath}/member/register">회원가입</a> 
							<a href="${pageContext.request.contextPath}/" id="loginBanner">로그아웃</a>
							
						</nav>

					</div>
				</div>
			</div>
		</section>
		<div id="copyright" align="center">
			<h2 align="center" style="font-size: 2em;">게시글 입력</h2>
			<br /> <br />
			<!-- boardtitle, boardcontent. boardattchment 입력 -->
			<div align="center">
				<form id="boardform" method="post" enctype="multipart/form-data"
					style="font-size: 1.2em;">
					제목:<input type="text" name="boardtitle" id="boardtitle" size="30" /><br />
					첨부파일:<input type="file" name="boardattachment" id="boardattachment" />
					<br />
					<textarea cols="100%" rows="10" name="boardcontent"
						id="boardcontent" style="font-size: 1em;"></textarea>
					<br />
				</form>
				<input type="button" value="글쓰기" id="boardwritebtn" /> <input
					type="button" value="게시판 목록으로" id="listbtn" /> <input
					type="button" value="메인으로" id="mainbtn" />
			</div>
		</div>



		<!-- Copyright -->
		<div id="copyright">&copy; yskim62100@gmail.com for any
			requirement</div>
	</div>
<script src="${pageContext.request.contextPath}/js/boardtbl/boardwrite.js"></script>
</body>
</html>