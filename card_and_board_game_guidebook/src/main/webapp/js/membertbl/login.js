window.addEventListener("load", function(event) {

			var loginform = document.getElementById("loginform");

			var membernickname = document.getElementById("membernickname");
			var memberpassword = document.getElementById("memberpassword");
			
			var mainbtn = document.getElementById("mainbtn");
			var loginbtn = document.getElementById("loginbtn");
			
			var loginmsg = document.getElementById("loginmsg");
			

			
			
			loginbtn.addEventListener("click", function(event) {
				
				var flag = false;
				loginmsg.innerHTML = '';
				if (membernickname.value.trim().length < 1) {
							loginmsg.innerHTML = '닉네임은 필수 입력입니다.<br/>';
							flag = true;
				}
				if (memberpassword.value.trim().length < 1) {
							loginmsg.innerHTML += '비밀번호는 필수 입력입니다.<br/>';
							flag = true;
				}

				if (flag == true) {
					event.preventDefault();
					return;
				}
				
				
				// alert("클릭");
				
				
				// 서버로 보내서 로그인 처리 -> ajax이용
				// 1. ajax 객체 생성
				var request = new XMLHttpRequest();
				
				// 2. ajax 요청 설정
				request.open('post', 'member/login', true);
				
				// 3. ajax 파라미터 설정
				// GET 방식이면 open의 URL뒤에 붙이고, POST 방식이면 FormData 객체를 생성하고 send
				var formdata = new FormData(loginform);
				
				// 4. ajax로 데이터 전송
				request.send(formdata);
				
				// 5. ajax 응답이 온 경우 처리할 콜백함수 등록
				request.addEventListener('load', function(event){
					// 결과만 확인
					// alert(event.target.responseText);
					
					var data = JSON.parse(event.target.responseText);
					// alert(data.result)
					
					// 로그인 실패한 경우
					if(data.result == false){
						alert("없는 email이거나 잘못된 비밀번호입니다.");
					}
					// 로그인 성공한 경우
					else {
						alert("로그인에 성공하셨습니다.")
						alert(data.membernickname);
						location.href = "../board/list";
					}
				});
				
				
			});
});
