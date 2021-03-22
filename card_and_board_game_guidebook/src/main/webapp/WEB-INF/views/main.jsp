<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 에러가 발생한 경우 보여질 페이지 설정 -->
<%@ page errorPage="${pageContext.request.contextPath}/WEB-INF/views/exceptionhandling/error404.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Card & board Game Guidebook</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css"/>
<!-- Global site tag (gtag.js) - Google Analytics -->
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
							<a href="${pageContext.request.contextPath}/member/login">로그인</a>
							
						</nav>

					</div>
				</div>
			</div>

			<div id="banner">
				<div class="container">
					<div class="row">
						<div class="col-6 col-12-medium">

							<!-- Banner Copy -->
							<img src="${pageContext.request.contextPath}/resources/images/trumpcard.jpg" id=trumpcard />
							
						</div>
						<div class="col-6 col-12-medium imp-medium">

							<!-- Banner Image -->
							<img src="${pageContext.request.contextPath}/resources/images/hwatu.jpg" id=hwatu />

						</div>
						<div class="">

							<!-- Banner Image -->
							<img src="${pageContext.request.contextPath}/resources/images/board_game.jpg" id=board_game />

						</div>
					</div>
				</div>
			</div>
		</section>

		<!-- Features -->
		<section id="features" >
			<div class="container" align="center">
				<h2 align="center">▶Welcome to C & B Guidebook◀</h2><br/>
				<p>
					<strong>
						<h2>Card and Bard Game Guidebook은</h2><br/>
						
						트럼프 카드 -> 포커 / 블랙잭 / 훌라 / 바카라<br/>
						보드 게임 -> 체스 / 바둑 / 장기 / 오목<br/>
						화투 -> 맞고 / 섯다<br/>
						<br/>
						트럼프 카드, 화투 및 보드 게임에 관한 각각의 게임 정보와 룰에 대한 서비스를 제공합니다.<br/>
					</strong> 
				</p>
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

</body>
</html>