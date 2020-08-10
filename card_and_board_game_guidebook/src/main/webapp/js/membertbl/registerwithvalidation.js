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
	
	// loginbtn을 클릭하면 로그인으로 이동
	document.getElementById("loginbtn").addEventListener("click", function(){
		location.href="login";
	})
	
	// email 중복검사 통과 여부를 저잘할 변수
	var emailcheck = false;
	
	memberemail.addEventListener("click", function(event){
		if(memberemail.value.trim().length == 0){
			memberemailmsg.innerHTML = "이메일을 입력하시길 바랍니다.";
			memberemail.style.color = "red";
			emailcheck = false;
			
			// 검사하지 않도록 리턴
			return;
		}
		
		//ajax 요청 객체 생성
		var request = new XMLHttpRequest();
		
		// 요청 생성
		request.open('get', 'memberemailcheck' + '?' + 'memberemail=' + memberemail.value, true);
		
		// 요청을 전송
		request.send('');
		
		// 결과를 받기 위한 부분 생성
		request.addEventListener('load', function(event){
			// alert(event.target.responseText);
			// 결과를 파싱
			var data = JSON.parse(event.target.responseText);
			if(data.result == true){
				memberemailmsg.innerHTML = "사용 가능한 이메일";
				memberemailmsg.style.color = "green";
				// email 중복 검사를 통과한 것 표시
				emailcheck = true;
			} else{
				memberemailmsg.innerHTML = "이미 사용 중인 이메일";
				memberemailmsg.style.color = "red";
				// email 중복 검사를 통과하지 못한 것 표시
				emailcheck = false;
			}
			
		});
		
		
		
	});
	
	
	//닉네임 중복 검사 통과여부를 저장할 변수
	var nicknamecheck = false;
	
	// 닉네임을 작성하고 포커스를 옮길 떄
	membernickname.addEventListener("focusout", function(event){
		// 입력할 내용이 없을 떄는 검사하지 않음
		if(membernickname.value.trim().length < 1){
			membernicknamemsg.innerHTML = "닉네임을 입력하세요";
			membernicknamemsg.style.color = 'red';
			nicknamecheck = false;
			return;
		}
		
		//ajax 요청 객체 생성
		var request = new XMLHttpRequest();
		
		// 요청 생성
		request.open('get', 'membernicknamecheck?membernickname=' + membernickname.value, true);
		
		// 요청을 전송
		request.send('');
		
		// 데이터를 가져왔을 때 호출될 메소드를 설정
		request.addEventListener('load', function(event){
			var data = JSON.parse(event.target.responseText);
			if(data.result == true){
				membernicknamemsg.innerHTML = "사용 가능한 별명";
				membernicknamemsg.style.color = "green";
				// nickname 중복 검사를 통과한 것 표시
				nicknamecheck = true;
			} else{
				membernicknamemsg.innerHTML = "이미 사용 중인 별명";
				membernicknamemsg.style.color = "red";
				// nickname 중복 검사를 통과하지 못한 것 표시
				nicknamecheck = false;
			}
		});
	});
	
	// 회원가입 버튼을 누르면
	registerbtn.addEventListener('click', function(event){
		// 폼의 데이터를 전송할 때는 유효성 검사를 해주어야 함
		// 필수 항목 검사, 형식 체크, 제한된 값 체크
		if(memberemail.value.trim().length < 1){
			memberemailmsg.innerHTML = "이메일은 필수 항목";
			memberemailmsg.style.color = "red";
			return;
		}
		//형식 검사 - 정규식을 이용
		var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
		if(emailRegExp.test(memberemail.value) == false){
			memberemailmsg.innerHTML = "이메일 형식에 맞지 않습니다.";
			memberemailmsg.style.color = "red";
			return;
		}
		
		if(emailcheck == false){
			memberemailmsg.innerHTML = "이미 가입된 이메일입니다.";
			memberemailmsg.style.color = "red";
			return;
		}
		
		if(nicknamecheck == false){
			membernicknamemsg.innerHTML = "사용 중인 별명입니다.";
			membernicknamemsg.style.color = "red";
			return;
		}
		
		// ajax 요청
		var request = new XMLHttpRequest();
		request.open('post', 'register', true);
		
		// 폼의 데이터 생성
		var formData = new FormData(registerform);
		alert(formData)
		// 폼의 데이터 전송
		request.send(formData);
		
		// 데이터를 전송하고 결과를 받아왔을 떄
		request.addEventListener('load', function(event){
			// alert(event.target.responseText);
			
			// JSON 파싱 결과를 사용하기 위해서
			var data = JSON.parse(event.target.responseText);
			if(data.result == true){
				// 메인으로 이동
				location.href = "../";
			}
		});
	});	

});