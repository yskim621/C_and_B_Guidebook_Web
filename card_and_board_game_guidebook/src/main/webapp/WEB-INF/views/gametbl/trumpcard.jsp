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
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/trumpcard.css"/>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/jquery.atAccordionOrTabs.css"/>

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


		<!-- Features -->
		<section id="header">
			<div class="container">
				<ul class="demo">
						<li><a><img src="${pageContext.request.contextPath}/resources/images/poker.jpg" id=poker onmouseover="pokerChangeImg()"/>
								<img src="${pageContext.request.contextPath}/resources/images/poker_hover.png" id=poker_hover height="200" width="275" onmouseout="pokerShowOriginal()" /></a>
							<section>
								<div class="thumb no6">
									<p class="bg"></p>
									<h2> 
									<strong>포커</strong> 
									<span>- 5장의 카드로 우열을 겨루어, 최고 등급의 조합을 가지면 이기는 게임</span>
									</h2>
								</div>

								<div class="game-guide">

									<div class="wrap">
										<div class="image">
											<img src="${pageContext.request.contextPath}/resources/images/poker.jpg" height="250" width="400" />
										</div>
										<div class="text">
											<h3>Texas Held'em Poker</h3>
											<p class="mt20">
												Texas Held'em Poker는 2장의 Hole card(손에 든 카드, Poket card라고도
												함)와 5장의 Community Card(테이블에 오픈 되는 공유카드)를 가지고 <span>총
													7장 중 5장의 카드로 우열을 겨루어 최고 등급의 조합을 가지는 게임</span>입니다.
											</p>
											<p>각 포커 게임에서는 52장으로 이루어진 한 벌의 표준 카드를 사용합니다. 카드의 랭킹은 Ace,
												King, Queen, Jack, 10...,4,3,2의 순으로 내려갑니다. 스트레이트(Straight)에서
												Ace는 2보다 낮은 랭킹의 카드로 사용할 수도 있습니다.</p>
										</div>
									</div>

									<div>
										<h3>핸드의 종류 및 서열</h3>
										<table class="center" border="2" bordercolor="#FFFFFF">
											<colgroup>
												<col width="25%" />
												<col width="50%" />
												<col width="25%" />
											</colgroup>
											<thead>
												<tr>
													<th>카드명</th>
													<th>설명</th>
													<th>예</th>
												</tr>
											</thead>
											<tbody>
												<tr>
													<td>Royal Flush</td>
													<td>동일한 무늬의 에이스, 킹, 퀸, 잭, 10으로 구성</td>
													<td>높음</td>
												</tr>
												<tr>
													<td>Straight Flush</td>
													<td>무늬가 동일하고 연속된 5개의 숫자로 구성</td>
													<td></td>
												</tr>
												<tr>
													<td>Four of a Kind<br></td>
													<td>동일한 랭킹의 카드 4장으로 구성('쿼즈 quads')</td>
													<td></td>
												</tr>
												<tr>
													<td>Full House</td>
													<td>3장의 카드가 동일한 랭킹이고, 다른 2장이 동일한 랭킹인 경우.<br>2명
														이상의 플레이어가 풀 하우스라면 3장의 카드의 랭킹이 높은 쪽이 이깁니다.
													</td>
													<td></td>
												</tr>
												<tr>
													<td>Flush</td>
													<td>동일한 무늬의 카드 5장으로 구성.<br>두 명 이상이 플러쉬라면 가장 높은
														카드를 가진 핸드가 승리합니다.
													</td>
													<td></td>
												</tr>
												<tr>
													<td>Straight</td>
													<td>무늬와 상관없이 5장의 카드가 연속되는 숫자인 경우.<br>에이스는 가장 높은
														스트레이트(A, K, Q, J, 10)와 가장 낮은 스트레이트(A, 2, 3, 4, 5)에서 모두 사용될
														수 있습니다.
													</td>
													<td></td>
												</tr>
												<tr>
													<td>Three of a Kind</td>
													<td>동일한 랭킹의 카드 3장으로 구성('트립스' 또는 '셋')</td>
													<td></td>
												</tr>
												<tr>
													<td>Two Pairs</td>
													<td>동일한 랭킹의 카드 2장이 2세트 있는 경우.<br>2명 이상의 플레이어가
														투페어라면 가장 높은 페어를 가진 핸드가 승리합니다.<br>카드의 랭킹이 동일하다면 두 번째
														페어가 높은 쪽이 승리합니다.<br>두 번째 페어도 동일하다면 다섯 번째 카드('키커')가 높은
														쪽이 승리합니다.
													</td>
													<td></td>
												</tr>
												<tr>
													<td>One Pair</td>
													<td>랭킹이 동일한 카드가 2장일 때.<br>2명 이상의 플레이어가 똑같이 원페어라면
														아웃사이드 카드가 높은 쪽이 승리합니다.
													</td>
													<td></td>
												</tr>
												<tr>
													<td>Ace+King</td>
													<td>가장 높은 카드를 가진 핸드가 승리합니다</td>
													<td>낮음</td>
												</tr>
											</tbody>
										</table>
										<p class="text mt20">만약 같은 순위를 가지는 플레이어가 있는 경우, 플레이어가 가진
											카드 중 족보에 영향을 미치는 더 높은 카드를 가지는 자가 이기게 되며, 영향을 미치는 카드마저 같은 순위의
											카드라면 Push가 됩니다. 이때 베팅금액을 나눠 갖게 되며, 이를 Split이라 합니다. 남은 플레이어
											모두가 족보에 영향을 미치는 카드를 가지지 않았을 경우 역시 Split이 되며 베팅금액을 나눠 갖게 됩니다.</p>
									</div>
								</div>
							</section></li>
						<li><a><img src="${pageContext.request.contextPath}/resources/images/black_jack.jpg" id=black_jack onmouseover="blackjackChangeImg()" />
								<img src="${pageContext.request.contextPath}/resources/images/blackjack_hover.png" id=blackjack_hover height="200" width="275" onmouseout="blackjackShowOriginal()"/></a>
						<section>
							<div id="black_jack_data">
							</div>
						</section></li>
						
						
					<li><a><img src="${pageContext.request.contextPath}/resources/images/bacara.jpg" id=bacara onmouseover="bacaraChangeImg()"/>
							<img src="${pageContext.request.contextPath}/resources/images/bacara_hover.png" id=bacara_hover height="200" width="275" onmouseout="bacaraShowOriginal()"/></a>
						<section>
							<div id="bacara_data">
							</div>
						</section></li>
					<li><a><img src="${pageContext.request.contextPath}/resources/images/hoola.png" id=hoola onmouseover="hoolaChangeImg()" />
							<img src="${pageContext.request.contextPath}/resources/images/hoola_hover.png" id=hoola_hover height="200" width="275" onmouseout="hoolaShowOriginal()"/></a>
						<section>
							<div id="hoola_data">
							</div>
						</section></li>
				</ul>
			</div>
		</section>
		</section>

		<!-- Content -->
		<section id="header">
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
								<li>
									<p>"Neque nisidapibus mattis"</p> <span>Jane Doe, CEO of
										UntitledCorp</span></li>
								<li>
									<p>"Lorem ipsum consequat!"</p> <span>John Doe,
										President of FakeBiz</span></li>
								<li>
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

	</div>

	<!-- Scripts -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/browser.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/breakpoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/js/main.js"></script>
	<script src="${pageContext.request.contextPath}/js/gametbl/black_jack.js"></script>
	<script src="${pageContext.request.contextPath}/js/gametbl/bacara.js"></script>
	<script src="${pageContext.request.contextPath}/js/gametbl/hoola.js"></script>
	<script src="${pageContext.request.contextPath}/js/gametbl/trumpcard.js"></script>
	
<!-- JQuery 이용을 위한 스크립트 링크  -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<script src="http://code.jquery.com/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.atAccordionOrTabs.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.bbq.js"></script>	
<script type="text/javascript">
$('.demo').accordionortabs();
</script>
<script type="text/javascript">
  document.querySelector('#poker_hover').style.display = "none";
  document.querySelector('#blackjack_hover').style.display = "none";
  document.querySelector('#bacara_hover').style.display = "none";
  document.querySelector('#hoola_hover').style.display = "none";
  
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