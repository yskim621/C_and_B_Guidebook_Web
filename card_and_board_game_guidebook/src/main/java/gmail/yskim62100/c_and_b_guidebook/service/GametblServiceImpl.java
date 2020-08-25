package gmail.yskim62100.c_and_b_guidebook.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gmail.yskim62100.c_and_b_guidebook.dao.GametblDao;


@Service
public class GametblServiceImpl implements GametblService {
	@Autowired
	private GametblDao gametblDao;

	@Override
	@Transactional
	public void gameinfo(HttpServletRequest request) {
		// 다운로드 받은 문자열을 저장할 변수
		String html = null;
		// 파싱한 결과를 저장할 map
		List<String> list = new ArrayList<String>();
		try {
			/* 요청 주소의 마지막 부분 가져오기
			// localhost/board/detail/boardnum
			String requestURI = request.getRequestURI();
			String [] ar = requestURI.split("/");
			String gamecode = ar[ar.length-1];
			
			System.out.println("gamecode: " + gamecode);
			
			// DAO 메소드 호출
			Gametbl gametbl = gametblDao.gameinfo(gamecode);
			System.out.println("Service: " + gametbl);
			*/
			
			// 1.주소 만들기 - 파라미터 확인
			//String gameinfo = gametbl.getGameinfo();
			String addr = "http://koreacasino.or.kr/kcasino/pr/gameGuide.do#";
			
			//URL url = new URL(gameinfo);
			URL url = new URL(addr);
			
			//2.연결 객체 만들기 - header 추가 여부 확인
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			con.setConnectTimeout(60000);
			con.setUseCaches(false);
			
			//헤더 설정
			
			//3.스트림을 만들어서 문자열 읽어오기
			//확인 한 후 한글이 깨지면 수정
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			//문자열을 임시로 저장할 인스턴스
			StringBuilder sb = new StringBuilder();
			
			//줄 단위로 읽어서 sb에 저장
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				sb.append(line + "\n");
			}
			html = sb.toString();
			
			//4.정리하기
			br.close();
			con.disconnect();
		
		} catch(Exception e) {
			System.err.println("다운로드 예외: " + e.getMessage());
			e.printStackTrace();
		}
		// 데이터 확인
		// System.out.println(html);
		
		// 데이터 존재 시 파싱
		if(html != null && html.trim().length() > 0) {
			//문서 구조 가져오기
			Document document = (Document) Jsoup.parse(html);
					
			Elements elements1 = document.getElementsByClass("thumb no1");
			Elements elements2 = document.getElementsByClass("game-guide first");
			
			//System.out.println("elements1: " + elements1);
			//System.out.println("elements2: " + elements2);
			
			// Serializable을 위해 toString으로 Elements의 자료형을 변환
			list.add(elements1.toString());
			list.add(elements2.toString());
			
			
			request.setAttribute("result", list);
			
		} else {
			System.out.println("읽어온 데이터가 없음");
		}
		
		
		
	}

}
