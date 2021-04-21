# Card & Board game Guidebook

Server - REST API
View - Web / Android


구성 - 게임 룰 및 정보를 전달하기 위한 부분 / 서비스에 대한 불편 사항을 게시할 수 있는 게시판 / 게시판을 이용하기 위한 회원가입과 로그인 형태로 구분
게시판 - 검색, 페이징, CRUD 등의 기본기능
회원가입 - email은 복호화 가능한 암호화, password는 복호화 불가능한 암호화(crypto)


컨텐츠 부분인 게임 룰 및 정보 전달 부분 - 타 웹사이트를 Crawling하여 HTML을 파싱한 데이터를 jQuery의 Accordion 형태로 구현
게시판, 회원가입, 로그인 부분 =  Server와 Client부분을 분리하여 서버 부분에서는 모든 데이터를 JSON으로 전송하여 뷰를 구현하는 방식으로 기본적인 게시판, 회원가입, 로그인을 구현

 
![image](https://user-images.githubusercontent.com/63395994/115343833-6fcaa180-a1e7-11eb-9444-7d810b4c1658.png)

![image](https://user-images.githubusercontent.com/63395994/115344020-adc7c580-a1e7-11eb-8ff2-91e3615b00e9.png)

![image](https://user-images.githubusercontent.com/63395994/115344071-c59f4980-a1e7-11eb-83ef-0fc1796d8d6b.png)

![image](https://user-images.githubusercontent.com/63395994/115344127-dbad0a00-a1e7-11eb-9291-145ebaf13710.png)




