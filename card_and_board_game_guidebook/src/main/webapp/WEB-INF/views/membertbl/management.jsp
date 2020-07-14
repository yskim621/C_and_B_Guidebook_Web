<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 관리</title>
</head>
<body>
	<h3 align="center">회원 정보 관리</h3>
	<div align="center" id="board">
		<table align="center" border="1">
			<tr>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>휴대폰 번호</th>
				<th>별명</th>
				<th>성별</th>
				<th>탈퇴 유무</th>
			</tr>
			<c:forEach var="membertbl" items="${list}">
				<tr>
					<td>
					<a href="detail/${membertbl.memberemail}">&nbsp;${membertbl.memberemail}</a>
					</td>
					<td>&nbsp;${membertbl.memberpassword}</td>
					<td>&nbsp;${membertbl.membername}</td> 
					<td>&nbsp;${membertbl.memberphone}</td>
					<td>&nbsp;${membertbl.membernickname}</td>
					<td>&nbsp;${membertbl.membergender}</td>
					<td>&nbsp;${membertbl.memberleave}</td>
				</tr>
			</c:forEach>
		</table>
		<input type="button" value="로그인 페이지로" id="loginpagebtn" name="loginpagebtn" />
		<input type="button" value="메인으로" id="mainbtn"/>
	</div>
</body>
<script>
	document.getElementById("loginpagebtn").addEventListener("click", function(){
		location="${pageContext.request.contextPath}/member/login";
	});
	document.getElementById("mainbtn").addEventListener("click", function() {
		location.href = "${pageContext.request.contextPath}/";
	});
</script>
</html>