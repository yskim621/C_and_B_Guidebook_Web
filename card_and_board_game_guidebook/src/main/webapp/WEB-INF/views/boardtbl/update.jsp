<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글</title>
</head>
<body>
	<h3 align="center">게시글 수정</h3>
	<div align="center" id="board">
		<form id="boardform" method="post" enctype="multipart/form-data">
			제목:<input type="text" value="${boardtbl.boardtitle}" name="boardtitle" id="boardtitle" size="30"/><br/>
			첨부파일:<input type="file" name="boardattachment" id="boardattachment"/> <br/> 
			게시글:<textarea cols="50" rows="30" name="boardcontent" id="boardcontent">${boardtbl.boardcontent}</textarea>
			<input type="hidden" id="boardnum" name="boardnum" value="${boardtbl.boardnum}"/>
			<input type="hidden" id="oldfile" name="oldfile" value="${boardtbl.boardattachment}"/>
			<input type="hidden" id="boardreadcnt" name="boardreadcnt" value="${boardtbl.boardreadcnt}"/>
		</form>
		<input type="button" value="수정 완료" id="boardupdatebtn" name="boardupdatebtn" />
		<input type="reset" value="수정 취소" id="cancelupdatebtn" name="cancelupdatebtn" /> 
		<input type="button" value="목록으로" id="listbtn" />
	</div>
</body>
<script src="${pageContext.request.contextPath}/js/boardtbl/boardupdate.js"></script>
</html>