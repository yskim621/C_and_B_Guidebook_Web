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
							<a href="${pageContext.request.contextPath}/board/list">게시판</a>
							<a href="${pageContext.request.contextPath}/member/register">회원가입</a> 
							<a href="${pageContext.request.contextPath}/member/login">로그인</a>
							
						</nav>

					</div>
				</div>
			</div>

			<div id="banner" align="center">
			<h2 align="center">서비스 개선 건의사항</h2>				
			<div class="container">
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

		<!-- Features -->
		<section id="features" >
			<div class="container" align="center">
			</div>
		</section>

		<!-- Content -->
		<section id="content">
			<div class="container">
				<div class="row aln-center">
					<div class="col-4 col-12-medium">

						<!-- Box #1 -->
						<section>
							<header>
								<h2>Who We Are</h2>
								<h3>A subheading about who we are</h3>
							</header>
							
							<p>Duis neque nisi, dapibus sed mattis quis, rutrum accumsan
								magna sed. Suspendisse eu varius nibh. Suspendisse vitae magna
								eget odio amet mollis justo facilisis quis. Sed sagittis amet
								lorem ipsum.</p>
						</section>

					</div>
					<div class="col-4 col-6-medium col-12-small">

						<!-- Box #2 -->
						<section>
							<header>
								<h2>What We Do</h2>
								<h3>A subheading about what we do</h3>
							</header>
							<ul class="check-list">
								<li>Sed mattis quis rutrum accum</li>
								<li>Eu varius nibh suspendisse lorem</li>
								<li>Magna eget odio amet mollis justo</li>
								<li>Facilisis quis sagittis mauris</li>
								<li>Amet tellus gravida lorem ipsum</li>
							</ul>
						</section>

					</div>
					<div class="col-4 col-6-medium col-12-small">

						<!-- Box #3 -->
						<section>
							<header>
								<h2>What People Are Saying</h2>
								<h3>And a final subheading about our clients</h3>
							</header>
							<ul class="quote-list">
								
									<p>"Neque nisidapibus mattis"</p> <span>Jane Doe, CEO of
										UntitledCorp</span></li>
								
									<p>"Lorem ipsum consequat!"</p> <span>John Doe,
										President of FakeBiz</span></li>
								
									<p>"Magna veroeros amet tempus"</p> <span>Mary Smith,
										CFO of UntitledBiz</span></li>
							</ul>
						</section>

					</div>
				</div>
			</div>
		</section>

		<!-- Footer -->
		<section id="footer">
			<div class="container">
				<div class="row">
					<div class="col-8 col-12-medium">

						<!-- Links -->
						<section>
							<h2>Links to Important Stuff</h2>
							<div>
								<div class="row">
									<div class="col-3 col-12-small">
										<ul class="link-list last-child">
											<li><a href="#">Neque amet dapibus</a></li>
											<li><a href="#">Sed mattis quis rutrum</a></li>
											<li><a href="#">Accumsan suspendisse</a></li>
											<li><a href="#">Eu varius vitae magna</a></li>
										</ul>
									</div>
									<div class="col-3 col-12-small">
										<ul class="link-list last-child">
											<li><a href="#">Neque amet dapibus</a></li>
											<li><a href="#">Sed mattis quis rutrum</a></li>
											<li><a href="#">Accumsan suspendisse</a></li>
											<li><a href="#">Eu varius vitae magna</a></li>
										</ul>
									</div>
									<div class="col-3 col-12-small">
										<ul class="link-list last-child">
											<li><a href="#">Neque amet dapibus</a></li>
											<li><a href="#">Sed mattis quis rutrum</a></li>
											<li><a href="#">Accumsan suspendisse</a></li>
											<li><a href="#">Eu varius vitae magna</a></li>
										</ul>
									</div>
									<div class="col-3 col-12-small">
										<ul class="link-list last-child">
											<li><a href="#">Neque amet dapibus</a></li>
											<li><a href="#">Sed mattis quis rutrum</a></li>
											<li><a href="#">Accumsan suspendisse</a></li>
											<li><a href="#">Eu varius vitae magna</a></li>
										</ul>
									</div>
								</div>
							</div>
						</section>

					</div>
					<div class="col-4 col-12-medium imp-medium">

						<!-- Blurb -->
						<section>
							<h2>An Informative Text Blurb</h2>
							<p>Duis neque nisi, dapibus sed mattis quis, rutrum accumsan
								sed. Suspendisse eu varius nibh. Suspendisse vitae magna eget
								odio amet mollis. Duis neque nisi, dapibus sed mattis quis, sed
								rutrum accumsan sed. Suspendisse eu varius nibh lorem ipsum amet
								dolor sit amet lorem ipsum consequat gravida justo mollis.</p>
						</section>

					</div>
				</div>
			</div>
		</section>

		<!-- Copyright -->
		<div id="copyright">
			&copy; Untitled. All rights reserved. | Design: <a
				href="http://html5up.net">HTML5 UP</a>
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