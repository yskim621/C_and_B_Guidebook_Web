package gmail.yskim62100.c_and_b_guidebook.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
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

				
				
				String content = elements1.toString();
				
				//System.out.println("content: " + content);
				
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
	public void gameinfo_gostop(HttpServletRequest request) {
		
		// 파싱한 결과를 저장할 map
		List<String> list = new ArrayList<String>();
		
		try {

			// 1.주소 만들기 - 파라미터 확인
			// String gameinfo = gametbl.getGameinfo();
			String addr = "https://lovem74.tistory.com/65";
			connection(addr);

			//System.out.println(html);

			// 데이터 존재 시 파싱
			if (html != null && html.trim().length() > 0) {
				// 문서 구조 가져오기
				Document document = (Document) Jsoup.parse(html);
				
				
				Elements elements1 = document.getElementsByClass("entry-content");

				
				
				String content = elements1.toString();
				
				//System.out.println("content: " + content);
				
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
	public void gameinfo_seosda(HttpServletRequest request) {
		
		// 파싱한 결과를 저장할 map
		List<String> list = new ArrayList<String>();
		
		try {

			// 1.주소 만들기 - 파라미터 확인
			// String gameinfo = gametbl.getGameinfo();
			String addr = "https://lovem74.tistory.com/35";
			connection(addr);

			//System.out.println(html);

			// 데이터 존재 시 파싱
			if (html != null && html.trim().length() > 0) {
				// 문서 구조 가져오기
				Document document = (Document) Jsoup.parse(html);
				
				
				Elements elements1 = document.getElementsByClass("entry-content");

				
				
				String content = elements1.toString();
				
				//System.out.println("content: " + content);
				
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
	
	
	// Boardgame
	@Override
	@Transactional
	public void gameinfo_chess(HttpServletRequest request) {
		
		// 파싱한 결과를 저장할 map
		List<String> list = new ArrayList<String>();
		
		try {

			// 1.주소 만들기 - 파라미터 확인
			// String gameinfo = gametbl.getGameinfo();
			
			String addr = "https://getitall.tistory.com/entry/%EC%B2%B4%EC%8A%A4-%EC%B2%9C%EC%9E%AC%EB%90%98%EA%B8%B0-%EC%B2%B4%EC%8A%A4%EC%9D%98-%EA%B8%B0%EB%B3%B8-%EA%B7%9C%EC%B9%99-%EA%B8%B0%EB%AC%BC%EC%9D%98-%EC%9B%80%EC%A7%81%EC%9E%84";
			//String addr = URLEncoder.encode(txtEnc, "UTF-8");
			//addr = https://getitall.tistory.com/entry/체스-천재되기-체스의-기본-규칙-기물의-움직임
			connection(addr);
			

			//System.out.println(html);

			// 데이터 존재 시 파싱
			if (html != null && html.trim().length() > 0) {
				// 문서 구조 가져오기
				Document document = (Document) Jsoup.parse(html);
				
				
				Elements elements1 = document.getElementsByClass("tt_article_useless_p_margin");
				
				
				String content = elements1.toString();
				
				//System.out.println("content: " + content);
				
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
		//System.out.println(html);

	}
	
	@Override
	@Transactional
	public void gameinfo_go(HttpServletRequest request) {
		
		// 파싱한 결과를 저장할 map
		List<String> list = new ArrayList<String>();
		
		try {

			// 1.주소 만들기 - 파라미터 확인
			// String gameinfo = gametbl.getGameinfo();
			
			String addr = "https://ko.wikibooks.org/wiki/%EB%B0%94%EB%91%91_%EC%9E%85%EB%AC%B8/%EA%B7%9C%EC%B9%99";
			//String addr = URLEncoder.encode(txtEnc, "UTF-8");
			connection(addr);
			//https://ko.wikibooks.org/wiki/바둑_입문/규칙
			

			//System.out.println(html);

			// 데이터 존재 시 파싱
			if (html != null && html.trim().length() > 0) {
				// 문서 구조 가져오기
				Document document = (Document) Jsoup.parse(html);
				
				
				Elements elements1 = document.getElementsByClass("mw-parser-output");
				
				
				String content = elements1.toString();
				
				//System.out.println("content: " + content);
				
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
		//System.out.println(html);

	}
	
	
	@Override
	@Transactional
	public void gameinfo_janggi(HttpServletRequest request) {
		
		// 파싱한 결과를 저장할 map
		List<String> list = new ArrayList<String>();
		
		try {

			// 1.주소 만들기 - 파라미터 확인
			// String gameinfo = gametbl.getGameinfo();
			
			String addr = "https://ko.wikibooks.org/wiki/%EC%9E%A5%EA%B8%B0/%EC%9E%A5%EA%B8%B0%EB%A5%BC_%EB%91%90%EB%8A%94_%EB%B0%A9%EB%B2%95";
			//String addr = URLEncoder.encode(txtEnc, "UTF-8");
			connection(addr);
			

			//System.out.println(html);

			// 데이터 존재 시 파싱
			if (html != null && html.trim().length() > 0) {
				// 문서 구조 가져오기
				Document document = (Document) Jsoup.parse(html);
				
				
				Elements elements1 = document.getElementsByClass("mw-body-content");
				
				
				String content = elements1.toString();
				
				//System.out.println("content: " + content);
				
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
		//System.out.println(html);

	}
	
	@Override
	@Transactional
	public void gameinfo_omok(HttpServletRequest request) {
		
		// 파싱한 결과를 저장할 map
		List<String> list = new ArrayList<String>();
		
		try {

			// 1.주소 만들기 - 파라미터 확인
			// String gameinfo = gametbl.getGameinfo();
			
			String addr = "https://schbeom.tistory.com/413";
			//String addr = URLEncoder.encode(txtEnc, "UTF-8");
			connection(addr);
			

			//System.out.println(html);

			// 데이터 존재 시 파싱
			if (html != null && html.trim().length() > 0) {
				// 문서 구조 가져오기
				Document document = (Document) Jsoup.parse(html);
				
				
				Elements elements1 = document.getElementsByClass("tt_article_useless_p_margin");
				
				
				String content = elements1.toString();
				
				//System.out.println("content: " + content);
				
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
		//System.out.println(html);

	}

}
