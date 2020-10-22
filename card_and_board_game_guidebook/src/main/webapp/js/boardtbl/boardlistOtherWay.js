window.addEventListener("load", function(event){
	

	document.writeln(" <h3 align=\"center\">서비스 개선 건의사항</h3> \n ");
	document.writeln(" <div align=\"center\" id=\"board\" > ");
	document.writeln(" <table align=\"center\" border=\"1\"> \n <tr> ");
	ar = [ '게시글 번호', '제목', '작성일', '조회수', '첨부파일', '작성자' ]; 
	for(var i=0; i<ar.length; i=i+1){
		document.writeln("<th>" + ar[i] + "</th>");
	}
	document.writeln(" </tr> \n");
	
	
	
	//ajax 요청 : select
	var url = "select";
		
	//ajax 객체를 생성
	var request = new XMLHttpRequest();
		
	//요청을 생성
	request.open('get', url, true);
			
	//요청을 전송
	request.send('');
	// event.preventDefault();
		
	//ajax 요청에 응답이 오면
	request.addEventListener("load", function(e){
		// console.log("클릭");
		// console.log(e.target.responseText);
		// 결과를 파싱
		var data = JSON.parse(e.target.responseText);
		//alert(data.list);
		//ar = data.list.split(",");
		for (temp in data.list){
			document.writeln("<tr>");
			document.writeln("<td>"+ data.list[temp].boardnum +"</td>");
			document.writeln("<td><a id='" + data.list[temp][0] + "' href='get/" + data.list[temp].boardnum + "'>"+ data.list[temp].boardtitle +"</a></td>");
			document.writeln("<td>"+ data.list[temp].boardwritedate +"</td>");
			document.writeln("<td>"+ data.list[temp].boardreadcnt +"</td>");
			document.writeln("<td>"+ data.list[temp].boardattachment +"</td>");
			document.writeln("<td>"+ data.list[temp].membernickname +"</td>");				
			document.writeln("</tr>");	
		}	
		document.writeln(" </table> \n");
		document.writeln("<input type=\"button\" value=\"글쓰기\" id=\"boardwritebtn\" name=\"boardwritebtn\" />");
		document.writeln("<input type=\"button\" value=\"메인으로\" id=\"mainbtn\" />");
		document.writeln(" </div> ");
		
		
		document.writeln(" <div align='center'> ");
		document.writeln(" <c:if test='${prev == true}'> ");
		document.writeln(" <a href='list?pageno=${startpage-1}'>이전</a> ");
		document.writeln(" </c:if> ");
		document.writeln(" <c:forEach var='idx'begin='${startpage}'end='${endpage}'>");
		document.writeln(" <c:if test='${pageno == idx'> ");
		document.writeln(" ${pageno}$nbsp; ");
		document.writeln(" </c:if>");
		document.writeln(" <c:if test='${pageno != idx}'> ");
		document.writeln(" <a href='list?pageno=${idx}'>${idx}</a>$nbsp; ");
		document.writeln(" </c:if> ");
		document.writeln(" </c:forEach>");
		document.writeln(" <c:if test='${next == true}'>");
		document.writeln(" <a href='list?pageno=${endpage+1}'>다음</a> ");
		document.writeln(" </c:if> ");
		document.writeln(" </div> ");
		
				
		document.getElementById("boardwritebtn").addEventListener("click", function(){
			location="write";
		});
		document.getElementById("mainbtn").addEventListener("click", function() {
			location.href = "../";
		});


	});
	
});