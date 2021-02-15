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
	
	// 다운로드 받은 문자열을 저장할 변수
	String html = null;
	
	public void connection(String addr) {
		// URL url = new URL(gameinfo);
		try {
			URL url = new URL(addr);

			// 2.연결 객체 만들기 - header 추가 여부 확인
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setConnectTimeout(60000);
			con.setUseCaches(false);

			// 헤더 설정

			// 3.스트림을 만들어서 문자열 읽어오기
			// 확인 한 후 한글이 깨지면 수정
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));

			// 문자열을 임시로 저장할 인스턴스
			StringBuilder sb = new StringBuilder();

			// 줄 단위로 읽어서 sb에 저장
			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				sb.append(line + "\n");
			}
			html = sb.toString();

			// 4.정리하기
			br.close();
			con.disconnect();

		} catch (Exception e) {
			System.err.println("스트림 읽기 예외: " + e.getMessage());
			e.printStackTrace();
		}
	}


	@Override
	@Transactional
	public void gameinfo_blackjack(HttpServletRequest request) {
		
		
		// 파싱한 결과를 저장할 map
		List<String> list = new ArrayList<String>();
		
		// 요청 주소의 마지막 부분 가져오기
		String requestURI = request.getRequestURI();
		String[] ar = requestURI.split("/");
		String gamecode = ar[ar.length - 1];

		//System.out.println("gamecode: " + gamecode);

		try {

			/*
			 * // DAO 메소드 호출 Gametbl gametbl = gametblDao.gameinfo(gamecode);
			 * System.out.println("Service: " + gametbl);
			 */

			// 1.주소 만들기 - 파라미터 확인
			// String gameinfo = gametbl.getGameinfo();
			String addr = "http://koreacasino.or.kr/kcasino/pr/gameGuide.do#";
			connection(addr);

			//System.out.println(html);

			// 데이터 존재 시 파싱
			if (html != null && html.trim().length() > 0) {
				// 문서 구조 가져오기
				Document document = (Document) Jsoup.parse(html);

				Elements elements1 = document.getElementsByClass("thumb no1");
				Elements elements2 = document.getElementsByClass("game-guide first");
				
				// Serializable을 위해 toString으로 Elements의 자료형을 변환
				String content = elements1.toString() + elements2.toString();
				list.add(content);
				
				content = "";

				request.setAttribute("result", list);

			} else {
				System.out.println("읽어온 데이터가 없음");
			}

		} catch (Exception e) {
			System.err.println("다운로드 예외: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	@Override
	@Transactional
	public void gameinfo_bacara(HttpServletRequest request) {
		
		// 파싱한 결과를 저장할 map
		List<String> list = new ArrayList<String>();
		
		try {

			// 1.주소 만들기 - 파라미터 확인
			// String gameinfo = gametbl.getGameinfo();
			String addr = "http://koreacasino.or.kr/kcasino/pr/gameGuide.do#";
			connection(addr);

			//System.out.println(html);

			// 데이터 존재 시 파싱
			if (html != null && html.trim().length() > 0) {
				// 문서 구조 가져오기
				Document document = (Document) Jsoup.parse(html);
				
				
				Elements elements1 = document.getElementsByClass("thumb no2");
				Elements elements2 = document.getElementsByClass("game-guide");
				

				
				
				String content = elements1.toString() + elements2.get(1).toString();
				
				list.add(content);
				
				content = "";

				
				request.setAttribute("result", list);

			} else {
				System.out.println("읽어온 데이터가 없음");
			}


		} catch (Exception e) {
			System.err.println("다운로드 예외: " + e.getMessage());
			e.printStackTrace();
		}
		// 데이터 확인
		// System.out.println(html);

	}
	
	
	@Override
	@Transactional
	public void gameinfo_hoola(HttpServletRequest request) {
		
		// 파싱한 결과를 저장할 map
		List<String> list = new ArrayList<String>();
		
		try {

			// 1.주소 만들기 - 파라미터 확인
			// String gameinfo = gametbl.getGameinfo();
			String addr = "https://lovem74.tistory.com/15";
			connection(addr);

			//System.out.println(html);

			// 데이터 존재 시 파싱
			if (html != null && html.trim().length() > 0) {
				// 문서 구조 가져오기
				Document document = (Document) Jsoup.parse(html);
				
				
				Elements elements1 = document.getElementsByClass("entry-content");
				//Elements elements2 = document.getElementsByClass("game-guide");
				

				
				
				String content = elements1.toString();
				
				list.add(content);
				
				content = "";

				
				request.setAttribute("result", list);

			} else {
				System.out.println("읽어온 데이터가 없음");
			}


		} catch (Exception e) {
			System.err.println("다운로드 예외: " + e.getMessage());
			e.printStackTrace();
		}
		// 데이터 확인
		// System.out.println(html);

	}
	//
}
