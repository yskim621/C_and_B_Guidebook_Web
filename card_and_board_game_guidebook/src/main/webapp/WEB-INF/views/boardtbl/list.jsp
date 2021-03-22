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
<script async src="https://www.googletagmanager.com/gtag/js?id=263332218"></script>
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
			<h2 align="center" style = "font-size:2em;">서비스 개선 건의사항</h2>	<br/><br/>			
			<div>
				<div align="center" id="board"></div>
					<div align="center">
						<!-- 
						<c:if test="${prev == true}">
							<a href="select?pageno=${startpage-1}">이전</a>
						</c:if>

						<c:forEach var="idx" begin="${startpage}" end="${endpage}">
							<c:if test="${pageno == idx}">
										${pageno}&nbsp;
									</c:if>
							<c:if test="${pageno != idx}">
								<a href="select?pageno=${idx}">${idx}</a>&nbsp;
									</c:if>
						</c:forEach>

						<c:if test="${next == true}">
							<a href="select?pageno=${endpage+1}">다음</a>
						</c:if>
						-->
					</div>
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
	
	
	<!-- Scripts -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/browser.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/breakpoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/boardtbl/boardlist.js"></script>
	
	<!-- jquery를 사용하기 위한 링크 설정 -->
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</body>
</html>