<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/login.css">

<script src="${pageContext.request.contextPath}/js/membertbl/login.js"></script>
</head>
<body>
	<h1 id="title">C & B Guidebook</h1>
	<div class="inner_login">
		<div class="login_myweb">
			<!--  action: 처리할 서버의 URL, method: 전송방식(get, post) enctype: file이 존재하는 경우만  multipart/form-data -->
			<!--  최근에는 조회를 제외하고는 action을 설정하지 않고 method는 post로 설정해서 get과 post로 구분 -->
			<form id="loginform">
				<div id="loginmsg" class="msg"></div>
				<fieldset>
					<legend class="screen_out">로그인 정보 입력폼</legend>
					<div class="box_login">
						<div class="inp_text">
							<label for="text" class="screen_out">닉네임</label> <input
								type="email" id="membernickname" name="membernickname"
								placeholder="닉네임을 입력하세요!">
						</div>
						<div class="inp_text">
							<label for="userpw" class="screen_out">비밀번호</label> <input
								type="password" id="memberpassword" name="memberpassword"
								placeholder="비밀번호를 입력하세요!">
						</div>
					</div>
				</fieldset>
			</form>
			<!-- 하나의 서버로 여러 디바이스의 요청을 처리하는 REST API 서버를 이용하는 경우에는 submit 대신에 button을 만들어서 버튼을 누르면 ajax로 요청을 처리 -->
			<!-- bootstrap같은 자바스크립트 라이브러리를 이용하면 button을 만들면 자동으로 submit으로 만드는 경우가 있음 -> 버튼을 form 외부에 생성해서 처리 -->
			<input type="button" class="btn_login" id="loginbtn" value="로그인" />
			<div class="login_append">
				<div class="inp_chk">
					<input type="checkbox" id="keepLogin" class="inp_radio"name="keepLogin"> 
					<label for="keepLogin" class="lab_g">
						<span class="img_top ico_check"></span> 
						<span class="txt_lab">로그인 상태 유지</span>
					</label>
				</div>
			</div>
			<div class="login_append" align="center">
				<a href="#" class="link_find">ID 찾기</a> 
				<a href="#"class="link_find">비밀번호 찾기</a> 
				<a href="${pageContext.request.contextPath}/member/register" class="link_find">회원가입</a> 
				<a href="${pageContext.request.contextPath}/" class="link_find">메인으로</a>
			</div>
		</div>
	</div>
</body>
</html>
