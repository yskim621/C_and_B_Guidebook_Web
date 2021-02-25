var board = document.getElementById("board");
var searchform =  document.getElementById("searchform");

	
//ajax 객체를 생성
var request = new XMLHttpRequest();

window.addEventListener("load", function(){
	var pageno = 1;
	
	ajaxGet(pageno);
});

function ajaxGet(pageno){
	//ajax 요청 : select
	var url = "select/" + pageno;
	
	//요청을 생성
	request.open('get', url, true);
	
	
	//요청을 전송
	request.send('');
	// event.preventDefault();
	
	//ajax 요청에 응답이 오면
	request.addEventListener("load", function(e){
		adddata(pageno, e);
	});
}

function ajaxPost(pageno, searchtype, value){
	//ajax 요청 : select
	var url = "select/" + pageno;
	
	//요청을 생성
	request.open('post', url, true);
	
	var formData = new FormData();
	formData.append("searchtype", searchtype);
	formData.append("value", value);
	
	//요청을 전송
	request.send(formData);
	
	//ajax 요청에 응답이 오면
	request.addEventListener("load", function(e){
		adddata(pageno, e);
	});
}




function adddata(pageno, e){


		// console.log("클릭");
		// console.log(e.target.responseText);
		
		
		var msg = "<div align=\"center\" id=\"board\" >"+
			 	  "<table align='center' border='4' >"+
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

	
		for (temp in data.list){
			msg +=  "<tr>" + 
    				"<td align='center'>"+ data.list[temp].boardnum +"</td>"+
    				"<td><a id='" + data.list[temp][0] + "' href='get/" + data.list[temp].boardnum + "'>"+ data.list[temp].boardtitle +"</a></td>"+
    				"<td align='center'>"+ data.list[temp].boardwritedate +"</td>"+
    				"<td align='center'>"+ data.list[temp].boardreadcnt +"</td>"+
    				"<td style='font-size:1em;'>"+ data.list[temp].boardattachment +"</td>"+
    				"<td>"+ data.list[temp].membernickname +"</td>"+
    				"</tr>"
		};
		
				
		msg	+=	"</table>"+
				"<div align='right'> <input type='button' value='글쓰기' id='boardwritebtn' name='boardwritebtn' style='align:right;'/>"+
				"<input type=\"button\" value=\"메인으로\" id=\"mainbtn\" style='margin-right:10%;margin-bottom:1.5%;margin-top:1%'/></div><br/>"+
				"<div><form id='searchform' style='margin-bottom:2em;'><select id='searchtype' name='searchtype'><option value='boardtitle' selected>제목</option><option value='membernickname'>작성자</option></select>"+
				"<span><input type='text' id='value' name='value'/></form>"+
				"<input type='button' value='검색' id='searchbtn'/></span><div>"+
				"</div>"+
				"<span align='center'>"
				
		if(data.prev == true){
			msg += "<input type='button' value='&lt' id='prev' style='font-size:1.5em;' onclick='ajaxGet(" + (data.startpage - 10) + ")'/>"
		}
		
		for(data.startpage; data.startpage<=data.endpage; data.startpage += 1){
			msg +=  "<button onclick='ajaxGet("+ data.startpage + ")' style='font-size:1.5em;'>" + data.startpage + "&nbsp;&nbsp;&nbsp;&nbsp;" + "</button>"	
		}
		
		if(data.next == true){
			msg +=  "<input type='button' value='&gt' id='next' style='font-size:1.5em;' onclick='ajaxGet(" + (data.endpage + 1) + ")'/>" 		
		}
		
		msg += "</span>"
		
		board.innerHTML = msg;
		
		document.getElementById("boardwritebtn").addEventListener("click", function(){
			location="write";
		});
		document.getElementById("mainbtn").addEventListener("click", function() {
			location.href = "../";
		});
		
		
		document.getElementById("searchbtn").addEventListener("click", function() {
			var searchtype =  document.getElementById("searchtype").value;
			var value =  document.getElementById("value").value;
			ajaxPost(pageno, searchtype, value);	
		});
	
}
