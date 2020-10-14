window.addEventListener("load", function(event){
	
	ar = [ '게시글 번호', '제목', '작성일', '조회수', '첨부파일', '작성자' ];
	
	var board = document.getElementById("board");
	
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
		
		var msg = "<div align=\"center\" id=\"board\" >"+
			 	  "<table align='center' border='1'>"+
				  "<tr>"+
				  "<th>"+'게시글 번호'+"</th>"+
				  "<th>"+'제목'+"</th>"+
				  "<th>"+'작성일'+"</th>"+
				  "<th>"+'조회수'+"</th>"+
				  "<th>"+'첨부파일'+"</th>"+
				  "<th>"+'작성자'+"</th>"+
				  "</tr>"
		
		// 결과를 파싱
		var data = JSON.parse(e.target.responseText);


	
		for (temp in data.list){
			msg +=  "<tr>" + 
    				"<td>"+ data.list[temp].boardnum +"</td>"+
    				"<td><a id='" + data.list[temp][0] + "' href='get/" + data.list[temp].boardnum + "'>"+ data.list[temp].boardtitle +"</a></td>"+
    				"<td>"+ data.list[temp].boardwritedate +"</td>"+
    				"<td>"+ data.list[temp].boardreadcnt +"</td>"+
    				"<td>"+ data.list[temp].boardattachment +"</td>"+
    				"<td>"+ data.list[temp].membernickname +"</td>"+
    				"</tr>"
		};
		
		msg += 	"</table>"+
				"<input type='button' value='글쓰기' id='boardwritebtn' name='boardwritebtn' />"+
				"<input type=\"button\" value=\"메인으로\" id=\"mainbtn\" />"+ 
				"</div>"
		
		board.innerHTML = msg;
				
		document.getElementById("boardwritebtn").addEventListener("click", function(){
			location="write";
		});
		document.getElementById("mainbtn").addEventListener("click", function() {
			location.href = "../";
		});


	});
	
});