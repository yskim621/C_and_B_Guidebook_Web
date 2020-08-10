// alert("링크 작성 성공");

// 스크립트 링크가 body위에 있다면 window의 load 이벤트 안에 작성
// jQuery에서의 $ -> window.addEventListener
window.addEventListener('load', function(event){
	var registerform = document.getElementById("registerform");
	var memberemail = document.getElementById("memberemail");
	var memberemailmsg = document.getElementById("memberemailmsg");
	
	var memberpassword = document.getElementById("memberpassword");
	var memberpasswordmsg = document.getElementById("memberpasswordmsg");
	
	var membernickname = document.getElementById("membernickname");
	var membernicknamemsg = document.getElementById("membernicknamemsg");
	
	var registerbtn = document.getElementById("registerbtn");
	var resetbtn = document.getElementById("resetbtn");
	var mainbtn = document.getElementById("mainbtn");
	var loginbtn = document.getElementById("loginbtn");
	
	// mainbtn을 클릭하면 메인 화면으로 이동
	document.getElementById("mainbtn").addEventListener("click", function(){
		location.href="../";
	})
	
	// loginbtn을 클릭하면 메인 화면으로 이동
	document.getElementById("loginbtn").addEventListener("click", function(){
		location.href="login";
	})
	
	
	// 회원가입 버튼을 누르면
	registerbtn.addEventListener('click', function(event){
		//alert("클릭");
		
		// ajax 요청
		var request = new XMLHttpRequest();
		request.open('post', 'register', true);
		
		// 폼의 데이터 생성
		var formData = new FormData(registerform);
		// alert(formData)
		
		// 폼의 데이터 전송
		request.send(formData);
		
		// 데이터를 전송하고 결과를 받아왔을 떄
		request.addEventListener('load', function(event){
			//alert(event.target.responseText);
			
			// JSON 파싱 결과를 사용하기 위해서
			var data = JSON.parse(event.target.responseText);
			if(data != null){
				// 로그인으로 이동
				location.href = "login";
			}
		});
	});	

});