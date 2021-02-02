var board = document.getElementById("board");
window.addEventListener("load", function(){
	var pageno = 1;
	adddata(pageno);
});

function adddata(pageno){

	
	//ajax 요청 : select
	var url = "select/" + pageno;
		
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
			 	  "<table align='center' border='4'>"+
				  "<tr>"+
				  "<th align='center'>"+'게시글 번호'+"</th>"+
				  "<th>"+'제목'+"</th>"+
				  "<th>"+'작성일'+"</th>"+
				  "<th>"+'조회수'+"</th>"+
				  "<th>"+'첨부파일'+"</th>"+
				  "<th>"+'작성자'+"</th>"+
				  "</tr>"
		
		// 결과를 파싱
		var data = JSON.parse(e.target.responseText);
		
		//alert(data.count);

	
		for (temp in data.list){
			msg +=  "<tr>" + 
    				"<td align='center'>"+ data.list[temp].boardnum +"</td>"+
    				"<td><a id='" + data.list[temp][0] + "' href='get/" + data.list[temp].boardnum + "'>"+ data.list[temp].boardtitle +"</a></td>"+
    				"<td align='center'>"+ data.list[temp].boardwritedate +"</td>"+
    				"<td align='center'>"+ data.list[temp].boardreadcnt +"</td>"+
    				"<td>"+ data.list[temp].boardattachment +"</td>"+
    				"<td>"+ data.list[temp].membernickname +"</td>"+
    				"</tr>"
		};
		
		// 더보기 버튼 만들기
		/* 현재 페이지가 종료 페이지보다 작을 때만 생성
		if(data.pageno < data.endpage){
			//페이지 번호 하나 올리기
			pageno = pageno + 1;
					
			msg += "<tr id='add'>" + "<td colspan='9' align='center'>" + "더보기"	+ "</td></tr>";
			$("#board").html($("#board").html() + msg);
			// id가 add 객체를 click하면 adddata라는 함수를 호출
			
		}
		*/	

				
		msg	+=	"</table>"+
				
				"<input type='button' value='글쓰기' id='boardwritebtn' name='boardwritebtn' />"+
				"<input type=\"button\" value=\"메인으로\" id=\"mainbtn\" />"+ 
				"</div>"
		
		
		for(i=0; i<data.endpage; i=i+1){
			msg +=  "<span align='center'><button onclick='adddata("+ (i +1) + ")'>" + (i+1) + "&nbsp;&nbsp;&nbsp;&nbsp;" + "</button></span>"	
			board.innerHTML = msg;
		}
		
		
		document.getElementById("boardwritebtn").addEventListener("click", function(){
			location="write";
		});
		document.getElementById("mainbtn").addEventListener("click", function() {
			location.href = "../";
		});
		

	});
	

}



			

