# Card & Board game Guidebook

 Server는 REST API로 구현하였고 View는 Rest Server로부터 받은 동일한 데이터로 각각 Web / Android를 구현

 C & B guidebook의 구성은 게임 룰 및 정보를 전달하기 위한 부분과 서비스에 대한 불편 사항을 게시할 수 있는 게시판 그리고, 게시판을 이용하기 위한 회원가입과 로그인 형태로 구분

 컨텐츠 부분인 게임 룰 및 정보 전달 부분은 타 웹사이트를 Crawling하여 HTML을 파싱한 데이터를 jQuery의 Accordion 형태로 구현하였습니다. 게시판, 회원가입, 로그인 부분은 Server와 Client부분을 분리하여 서버 부분에서는 모든 데이터를 JSON으로 전송하여 뷰를 구현하는 방식으로 기본적인 게시판, 회원가입, 로그인을 구현

 각각 게시판은 검색, 페이징, CRUD 등의 기본기능, 회원가입은 email은 복호화 가능한 암호화, password는 복호화 불가능한 암호화(crypto)로 구성
