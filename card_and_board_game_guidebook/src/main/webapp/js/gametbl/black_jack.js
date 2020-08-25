window.addEventListener("load", function(event){
	var black_jack = document.getElementById("black_jack");
	
	black_jack.addEventListener("click", function(event){
		//alert("클릭");
		
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