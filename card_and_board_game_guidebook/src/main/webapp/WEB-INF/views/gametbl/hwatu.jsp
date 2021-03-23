<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 에러가 발생한 경우 보여질 페이지 설정 -->
<%@ page errorPage="${pageContext.request.contextPath}/ceptionhandling/error404.jsp"%>
<!DOCTYPE html>
<html>
<head>
<title>Card & board Game Guidebook</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/hwatu.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.atAccordionOrTabs.css"/>
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
		<section id="header" >
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
		
			<!-- Features -->
			<section id="header">
				<div class="container" align="center">
					<ul class="demo">
						<li>
							<a>
								<img src="${pageContext.request.contextPath}/resources/images/gostop.jpg" id=gostop onmouseover="gostopChangeImg()" />
								<img src="${pageContext.request.contextPath}/resources/images/gostop_hover.jpg" id=gostop_hover height="200" width="275" onmouseout="gostopShowOriginal()" />
							</a>
								
						<section>
							<div id="gostop_media">
								<iframe width="560" height="315" src="https://www.youtube.com/embed/pb-4hAMSwRY" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
							</div>
							<div id="gostop_data"></div>
						</section>
						</li>
						
						
						<li>
							<a>
								<img src="${pageContext.request.contextPath}/resources/images/seosda.png" id=seosda onmouseover="seosdaChangeImg()" />
								<img src="${pageContext.request.contextPath}/resources/images/seosda_hover.jpeg" id=seosda_hover height="200" width="275" onmouseout="seosdaShowOriginal()" />
							</a>
							
						<section>
							<div id="seosda_media">
								<iframe width="560" height="315" src="https://www.youtube.com/embed/9PqPpkktdu4" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
							</div>	
							<div id="seosda_data"></div>
						</section></li>
					</ul>
				</div>
			</section>
		</section>


		<!-- Content --------------------------------------------->
		<section id="header">
			<div class="container">
				<div class="row aln-center">

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
<script src="${pageContext.request.contextPath}/js/gametbl/gostop.js"></script>
<script src="${pageContext.request.contextPath}/js/gametbl/seosda.js"></script>


<!-- JQuery 이용을 위한 스크립트 링크  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.atAccordionOrTabs.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.bbq.js"></script>
	
<script type="text/javascript">
$('.demo').accordionortabs();
</script>
<script type="text/javascript">
  document.querySelector('#gostop_hover').style.display = "none";
  document.querySelector('#seosda_hover').style.display = "none";

  
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>	
</body>
</html>