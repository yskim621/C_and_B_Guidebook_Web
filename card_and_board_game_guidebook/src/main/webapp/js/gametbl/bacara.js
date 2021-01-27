window.addEventListener("load", function(event){
	var bacara = document.getElementById("bacara_hover");
	var bacara_data = document.getElementById("bacara_data");


	
	bacara.addEventListener("click", function(event){
		//alert("클릭");
		bacara_data.innerHTML = " ";
		//ajax 요청 : select
		var url = "trumpcard/bacara";
		
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
			bacara_data.innerHTML = data.result
			
			document.querySelectorAll(".center")[1].setAttribute("border", 5);
			document.querySelectorAll(".center")[1].setAttribute("style", "text-align: center;");
			document.querySelectorAll(".center")[2].setAttribute("border", 5);
			document.querySelectorAll(".center")[2].setAttribute("style", "text-align: center;");
			
			
		});
		
	});
	
	
});
