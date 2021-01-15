window.addEventListener("load", function(event){
	var black_jack = document.getElementById("blackjack_hover");
	var black_jack_data = document.getElementById("black_jack_data");
	
	
	black_jack.addEventListener("click", function(event){
		//alert("클릭");
		black_jack_data.innerHTML = " ";
		
		//ajax 요청 : select
		var url = "trumpcard/black_jack";
		
		//ajax 객체를 생성
		var request = new XMLHttpRequest();
		
		//요청을 생성
		request.open('get', url, true);
		
		
		//요청을 전송
		request.send('');
		// console.log(formData);
		
		//ajax 요청에 응답이 오면
		request.addEventListener("load", function(e){
			// alert("클릭");
			// console.log(e.target.responseText)
			// 결과를 파싱
			var data = JSON.parse(e.target.responseText);
			// alert(data.result);
			// console.log(data);
			
			black_jack_data.innerHTML = data.result
			
		});
		
	});
	
	
});

function blackjackChangeImg(){
	document.querySelector('#black_jack').style.display = "none";
	document.querySelector('#blackjack_hover').style.display = "block";	
}
  
function blackjackShowOriginal() {	
	document.querySelector('#blackjack_hover').style.display = "none";
	document.querySelector('#black_jack').style.display = "block";
}