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

  gtag('config', '263332218');
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

			<div id="banner" align="center">
				<h2 align="center"  style = "font-size:2em;">게시글 보기</h2><br/><br/>
				<div align="center" id="board">
					<form id="boardform" name="${boardtbl.boardnum}" style = "font-size:1.1em;">
						<table border="3" id="boardform">
							<tr>
								<td>제목: &nbsp;${boardtbl.boardtitle}</td>
							</tr>
							<tr>
								<td>&nbsp;${boardtbl.membernickname}<br />
									&nbsp;${boardtbl.boardwritedate} &nbsp;
									조회수:${boardtbl.boardreadcnt}
								</td>
							</tr>
							<tr>
								<td>&nbsp;${boardtbl.boardattachment}</td>
							</tr>
							<tr>
								<td><textarea cols="100%" rows="10" name="boardcontent" id="boardcontent" style = "font-size:1em;">${boardtbl.boardcontent}</textarea></td>
							</tr>
						</table>
						<a href="../alter/${boardtbl.boardnum}"><input type="button" value="수정" id="updatebtn" name="updatebtn" /></a> 
						<input type="button" value="삭제" id="deletebtn" name="deletebtn" /> 
						<input type="button" value="목록으로" id="listbtn" /> <input type="hidden" id="boardnum" name="boardnum" value="${boardtbl.boardnum}" />
					</form>
				</div>
			</div>
		</section>



		<!-- Content -->
		<section id="banner">
			<div class="container">
				<div>
					<div>

						<!-- Box #1 -->
						<section>

						</section>

					</div>
					<div class="col-4 col-6-medium col-12-small">

						<!-- Box #2 -->
						<section>

						</section>

					</div>
					<div class="col-4 col-6-medium col-12-small">

						<!-- Box #3 -->
						<section>

						</section>

					</div>
				</div>
			</div>
		</section>



		<!-- Copyright -->
		<div id="copyright">
			&copy; yskim62100@gmail.com for any requirement
		</div>

	</div>
<script src="${pageContext.request.contextPath}/js/boardtbl/boarddetail.js"></script>
</body>
</html>