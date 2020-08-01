window.addEventListener("load", function(event){
	
	
	
	//ajax 요청 : detail
	var url = "../detail/" + boardtbl["boardnum"];
		
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
		alert(data);
		document.writeln(" <h3 align='center'>게시글 보기</h3> \n ");
		document.writeln(" <div align='center' id='board'> ");
		document.writeln(' <table align="center" border="1"> \n ');
	
		document.writeln(" <tr><td>제목: " + "테스트" +"</td><br/> </tr> \n");
		document.writeln(" </table> \n");
		document.writeln("<input type=\"button\" value=\"글쓰기\" id=\"boardwritebtn\" name=\"boardwritebtn\" />");
		document.writeln("<input type=\"button\" value=\"메인으로\" id=\"mainbtn\" />");
		document.writeln(" </div> ");
		
		document.getElementById("boardwritebtn").addEventListener("click", function(){
			location="write";
		});
		document.getElementById("mainbtn").addEventListener("click", function() {
			location.href = "../";
		});
	});
});