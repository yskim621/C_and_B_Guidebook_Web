// alert("링크 작성 성공");

// 스크립트 링크가 body위에 있다면 window의 load 이벤트 안에 작성
// jQuery에서의 $ -> window.addEventListener
window.addEventListener('load', function(event){
	var registerform = document.getElementById("registerform");
	var memberemail = document.getElementById("memberemail");
	var memberemailmsg = document.getElementById("memberemailmsg");
	
	var memberpassword = document.getElementById("memberpassword");
	var memberpasswordmsg = document.getElementById("memberpasswordmsg");
	var memberpasswordinform = document.getElementById("memberpasswordinform");
	
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

	
	var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	var pwRegExp = /^.*(?=^.{1,15}$)(?=.*\d)(?=.*[a-z])(?=.*[!@#$%^&+=]).*$/;
	var nicknameRegExp = /^[a-zA-z0-9]{5,30}$/;
	
	// 회원가입 버튼을 누르면
	registerbtn.addEventListener('click', function(event){
		//alert("클릭");
		var flag = false;
		memberemailmsg.innerHTML = '';
		memberpasswordmsg.innerHTML = '';
		membernicknamemsg.innerHTML = '';
		if (memberemail.value.trim().length < 1) {
			memberemailmsg.innerHTML = '이메일은 필수 입력입니다.<br/>';
			memberemailmsg.style.color = "red";
			flag = true;
		} else if (!emailRegExp.test(memberemail.value.trim())) {
			memberemailmsg.innerHTML = '잘못된 이메일 형식입니다.<br/>';
			memberemailmsg.style.color = "red";
			flag = true;
		}
		
		
		if (memberpassword.value.trim().length < 1) {
			memberpasswordmsg.innerHTML = '비밀번호는 필수 입력입니다.<br/>';
			memberpasswordmsg.style.color = "red";
			flag = true;
		} else if (!pwRegExp.test(memberpassword.value.trim())) {
			memberpasswordmsg.innerHTML = '비밀번호는 숫자와 영문 소문자 그리고 특수문자가 포함되어야 합니다.<br/>';
			memberpasswordmsg.style.color = "red";
			flag = true;
		} else if (memberpassword.value.trim() != memberpasswordinform.value.trim()) {
			memberpasswordmsg.innerHTML = '2개의 비밀번호는 같아야 합니다.<br/>';
			memberpasswordmsg.style.color = "red";
			flag = true;
		}	
		
		if (membernickname.value.trim().length < 1) {
			membernicknamemsg.innerHTML = '닉네임은 필수 입력입니다.<br/>';
			membernicknamemsg.style.color = "red";
			flag = true;
		} else if (!nicknameRegExp.test(membernickname.value.trim())) {
			membernicknamemsg.innerHTML = '닉네임은 영문 숫자로 5자 이상 30자 이하이어야 합니다.<br/>';
			membernicknamemsg.style.color = "red";
			flag = true;
		}
		
		if (flag == true) {
			
			event.preventDefault();
			return;
		}

		
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
			//alert(data.result);
			
			if(data.result == true){
				// 로그인으로 이동
				location.href = "login";
			}
		});
	});	

});