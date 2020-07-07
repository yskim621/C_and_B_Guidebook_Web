window.addEventListener("load", function(event) {

			var loginform = document.getElementById("loginform");

			var memberemail = document.getElementById("memberemail");
			var memberpassword = document.getElementById("memberpassword");
			
			var mainbtn = document.getElementById("mainbtn");
			var loginbtn = document.getElementById("loginbtn");
			
			var loginmsg = document.getElementById("loginmsg");
			
			// mainbtn을 클릭할 때 메인 페이지로 보내기
			/*
			mainbtn.addEventlistener("click", function(event){
				location.href = "../";
			});
			*/
			
			
			
			
			
			
			loginbtn.addEventListener("click", function(event) {
				/*
				loginmsg.innerHTML = '';
						var flag = false;
						if (memberemail.value.trim().length < 1) {
							loginmsg.innerHTML = '이메일은 필수 입력입니다.<br/>';
							flag = true;
						} else {
						var emailRegExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
						if (!emailRegExp.test(memberemail.value.trim())) {
							loginmsg.innerHTML = '잘못된 이메일 형식입니다.<br/>';
							flag = true;
						}
				}
				if (memberpassword.value.trim().length < 1) {
							loginmsg.innerHTML += '비밀번호는 필수 입력입니다.<br/>';
							flag = true;
				}

				if (flag == true) {
					event.preventDefault();
				}
				*/
				
				// alert("클릭");
				
				
				// 서버로 보내서 로그인 처리 -> ajax이용
				// 1. ajax 객체 생성
				var request = new XMLHttpRequest();
				
				// 2. ajax 요청 설정
				request.open('post', 'login', true);
				
				// 3. ajax 파라미터 설정
				// GET 방식이면 open의 URL뒤에 붙이고, POST 방식이면 FormData 객체를 생성하고 send
				var formdata = new FormData(loginform);
				
				alert(formdata.value("memberemail"));
				request.send(formdata);
				// 4. ajax 응답이 온 경우 처리할 콜백함수 등록
				request.addEventListener('load', function(event){
					// 결과만 확인
					// alert(event.target.responseText);
					
					// 로그인 실패한 경우
					if(event.target.responseText.trim().length == 0){
						alert("없는 email이거나 잘못된 비밀번호입니다.");
					}
					// 로그인 성공한 경우
					else {
						location.href = "../";
					}
				});
				
				
			});
});
