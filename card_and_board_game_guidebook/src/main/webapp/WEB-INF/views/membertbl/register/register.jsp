<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
<!-- register/js/register.js -->
<script src="${pageContext.request.contextPath}/js/membertbl/register.js"></script>
</head>
<body>
	<div id="form" align="center">
		<form  id="registerform">
			<h2 align="center">-회원가입-</h2><br />
			<table>
				<tr>
					<td>
					<input type="text" id="membernickname" name="membernickname" class="textinput" placeholder="영문 혹은 숫자로 로그인에 사용할 별명(5~30자)을 입력하시오." />
					<div id="membernicknamemsg"></div>
					</td>
				</tr>
				<tr>
					<td>
					<input type="text" id="memberemail" name="memberemail"class="textinput" placeholder="email을 입력하십시오." />
					<div id="memberemailmsg"></div>
					</td>
				</tr>
				<tr>
					<td>
					<input type="password" id="memberpassword" name="memberpassword" class="textinput" placeholder="영문 대소문자, 숫자, 특수문자를 포함한 비밀번호를 입력하시오." maxlength="15" />
					<div id="memberpasswordmsg"></div>
					</td>
				</tr>
				<tr>
					<td><input type="password" id="memberpasswordinform" name="memberpasswordinform" class="textinput" placeholder="비밀번호 확인." maxlength="15" /></td>
				</tr>
				<tr>
					<td><input type="text" id="membername" name="membername" class="textinput" placeholder="이름을 입력하시오." /></td>
				</tr>
				<tr>
					<td><input type="text" id="memberphone" name="memberphone"
						class="textinput" placeholder="전화번호 11자리(숫자만 입력)를 입력하시오." /></td>
				</tr>
				<tr>
					<td>
						<fieldset id="membergender" name="membergender">
							<legend>성별</legend>
							<input type="radio" value="man" name="membergender" checked="checked" />남자
							<input type="radio" value="woman" name="membergender" />여자
						</fieldset>
					</td>
				</tr>
			</table>
		</form>
		<!-- form 내부에 있는 버튼은 submit으로 인식 -->
		<input type="button" value="회원가입" id="registerbtn" /> 
		<input type="reset" value="작성취소" id="resetbtn"/>
		<input type="button" value="메인 페이지로" id="mainbtn"/>
		<input type="button" value="로그인 페이지로" id="loginbtn"/>

		<footer>
			<h3>C & B Guidebook에 오신 것을 환영합니다</h3>
		</footer>
	</div>
</body>
</html>