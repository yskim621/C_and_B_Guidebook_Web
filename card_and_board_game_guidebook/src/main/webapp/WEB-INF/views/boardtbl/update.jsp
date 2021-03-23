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
<script async src="https://www.googletagmanager.com/gtag/js?id=G-2H59G05B23"></script>
<script>
  window.dataLayer = window.dataLayer || [];
  function gtag(){dataLayer.push(arguments);}
  gtag('js', new Date());

  gtag('config', 'G-2H59G05B23');
</script>
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
			<h2 align="center" style="font-size: 2em;">게시글 수정</h2>
			<br />
			<br />
			<br />
			<div align="center" id="board">
				<form id="boardform" method="post" enctype="multipart/form-data"
					style="font-size: 1.2em;">
					제목:<input type="text" value="${boardtbl.boardtitle}"
						name="boardtitle" id="boardtitle" size="30" /><br /> 첨부파일:<input
						type="file" name="boardattachment" id="boardattachment"
						style="font-color: #FFFFFF;" /> <br />
					<textarea cols="100%" rows="10" name="boardcontent"
						id="boardcontent" style="font-size: 1em;">${boardtbl.boardcontent}</textarea>
					<input type="hidden" id="boardnum" name="boardnum"
						value="${boardtbl.boardnum}" /> <input type="hidden" id="oldfile"
						name="oldfile" value="${boardtbl.boardattachment}" /> <input
						type="hidden" id="boardreadcnt" name="boardreadcnt"
						value="${boardtbl.boardreadcnt}" />
				</form>
				<input type="button" value="수정 완료" id="boardupdatebtn"
					name="boardupdatebtn" /> <input type="reset" value="수정 취소"
					id="cancelupdatebtn" name="cancelupdatebtn" /> <input
					type="button" value="목록으로" id="listbtn" />
			</div>
		</div>


		<!-- Copyright -->
		<div id="copyright">
			&copy; yskim62100@gmail.com for any requirement
		</div>

	</div>
<script src="${pageContext.request.contextPath}/js/boardtbl/boardupdate.js"></script>
</body>
</html>