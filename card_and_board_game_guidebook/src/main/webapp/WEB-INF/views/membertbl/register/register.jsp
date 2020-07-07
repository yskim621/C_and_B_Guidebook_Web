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
<script src="${pageContext.request.contextPath}/js/register.js"></script>
</head>
<body>
	<div id="form" align="center">
		<form  id="registerform" enctype="multipart/form-data">
			<h2 align="center">-회원가입-</h2><br />
			<table align="center">
				<tr>
					<td>
					<input type="text" id="memberemail" name="memberemail"class="textinput" placeholder="email을 입력하십시오." />
					<div id="memberemailmsg"></div>
					</td>
				</tr>
				<tr>
					<td><input type="password" id="memberpassword" name="memberpassword" class="textinput" placeholder="비밀번호(15자리이하)를 입력하시오." maxlength="15" /></td>
					<td><div id="memberpasswordmsg"></div></td>
				</tr>
				<tr>
					<td><input type="password" id="memberpasswordinform" name="memberpasswordinform" class="textinput" placeholder="비밀번호 확인." maxlength="15" /></td>
				</tr>
				<tr>
					<td><input type="text" id="membername" name="membername" class="textinput" placeholder="이름을 입력하시오." /></td>
				</tr>
				<tr>
					<td>
					<input type="text" id="membernickname" name="membernickname" class="textinput" placeholder="별명을 입력하시오." />
					<div id="membernicknamemsg"></div>
					</td>
				</tr>
				<tr>
					<td><input type="text" id="memberphone" name="memberphone"
						class="textinput" placeholder="전화번호 8자리(숫자만 입력)를 입력하시오." /></td>
				</tr>
				<tr>
					<td>
						<fieldset id="membergender">
							<legend>성별</legend>
							<input type="radio" value="man" name="membergender" checked="checked" />남자
							<input type="radio" value="woman" name="membergender" />여자
						</fieldset>
					</td>
				</tr>
				<tr>
					<td>
					<!--  웹만 하면 type은 submit -->
					<input type="button" value="회원가입" id="registerbtn" /> 
					<input type="reset" value="작성취소" id="resetbtn"/>
					<input type="button" value="메인 페이지로" id="mainbtn"/>
					<input type="button" value="로그인 페이지로" id="loginbtn"/>
					</td>
				</tr>
			</table>
		</form>

		<footer>
			<h3>C & B Guidebook에 오신 것을 환영합니다</h3>
		</footer>
	</div>
</body>
</html>