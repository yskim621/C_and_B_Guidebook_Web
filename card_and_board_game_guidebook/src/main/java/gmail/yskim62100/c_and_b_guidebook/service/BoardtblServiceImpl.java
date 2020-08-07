package gmail.yskim62100.c_and_b_guidebook.service;


import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import gmail.yskim62100.c_and_b_guidebook.dao.BoardtblDao;
import gmail.yskim62100.c_and_b_guidebook.domain.Boardtbl;

@Service
public class BoardtblServiceImpl implements BoardtblService {
	@Autowired
	private BoardtblDao boardtblDao;

	
	@Override
	@Transactional
	public void select(HttpServletRequest request) {
		// 파라미터 읽기
		String searchtype = request.getParameter("searchtype");
		String value = request.getParameter("value");
		String pageno = request.getParameter("pageno");
		// 작업을 수행
		// 한 페이지에 보여질 데이터 개수
		int size = 10;
		// 시작 위치 번호를 저장할 변수
		// MySQL은 데이터 번호가 0부터 시작합니다.
		int start = 0;
		if (pageno != null) {
			start = (Integer.parseInt(pageno) - 1) * size;
		}

		// DAO 메소드의 파라미터를 만들기
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("searchtype", searchtype);
		map.put("value", value);
		map.put("start", start);
		map.put("size", size);

		// DAO 메소드를 호출해서 결과를 저장
		List<Boardtbl> list = boardtblDao.select(map);
		request.setAttribute("list", list);
		int count = boardtblDao.count(map).intValue();
		request.setAttribute("count", count);

	}


	@Override
	@Transactional
	public void detail(HttpServletRequest request) {
		// 요청 주소의 마지막 부분 가져오기
		// localhost/board/detail/boardnum
		String requestURI = request.getRequestURI();
		String [] ar = requestURI.split("/");
		String boardnum = ar[ar.length-1];
		
		System.out.println("boardnum: " + boardnum);
		
		// DAO 메소드 호출
		Boardtbl boardtbl = boardtblDao.detail(Integer.parseInt(boardnum));
		System.out.println("Service: " + boardtbl);
		
		// 결과 저장
		request.setAttribute("boardtbl", boardtbl);
	}
	
	
	@Override
	@Transactional
	public void insert(MultipartHttpServletRequest request) {
		// boardnum, boardtitle, boardcontent,
		// boardattachment을 만들어서 데이터를 삽입
		int boardnum = 1;
		// 데이터 개수 가져오기
		int count = boardtblDao.count(new HashMap<String, Object>()).intValue();
		// 데이터가 존재하면 가장 큰 itemid의 값에 +1
		if (count != 0) {
			boardnum = boardtblDao.maxid() + 1;
		}
		
		String boardtitle = request.getParameter("boardtitle");
		String boardcontent = request.getParameter("boardcontent");

		// 파일의 기본값을 설정
		String boardattachment = null;
		// 파일 파라미터 가져오기
		MultipartFile image = request.getFile("boardattachment");
		// 전송된 파일이 존재하면
		if (image != null && image.isEmpty() == false) {
			// 파일을 저장할 디렉토리 경로 가져오기
			String filePath = request.getRealPath("/img");
			// 새로운 파일명 만들기
			boardattachment = UUID.randomUUID() + image.getOriginalFilename();
			// 실제 파일 경로 만들기
			filePath = filePath + "/" + boardattachment;
			try {
				// 파일을 기록할 출력 스트림 생성
				FileOutputStream fos = new FileOutputStream(filePath);
				// 파일 업로드
				fos.write(image.getBytes());
				fos.close();
			} catch (Exception e) {
				System.out.println("파일 저장 예외:" + e.getMessage());
			}

			Boardtbl boardtbl = new Boardtbl();
			boardtbl.setBoardnum(boardnum);
			boardtbl.setBoardtitle(boardtitle);
			boardtbl.setBoardcontent(boardcontent);
			boardtbl.setBoardattachment(boardattachment);
			boardtbl.setBoardwritedate(new Date());
			boardtbl.setMembernickname("광고문의");

			boardtblDao.insert(boardtbl);

			request.setAttribute("insert", true);
		}	
		 
	}
	
	
	@Override
	@Transactional
	// Annotation에 Transactional 입력 안하면 하이버네이트 transaction 에러
	public void update(MultipartHttpServletRequest request) {
		// boardnum, boardtitle, boardcontent,
		// boardattachment을 만들어서 데이터를 삽입
		String requestURI = request.getRequestURI();
		String [] ar = requestURI.split("/");
		String boardnum = ar[ar.length-1];
		
		String boardtitle = request.getParameter("boardtitle");
		String boardcontent = request.getParameter("boardcontent");
		String oldfile = request.getParameter("oldfile");
		System.out.println(boardnum);
		System.out.println(boardtitle);
		System.out.println(boardcontent);
		
		
		// 파일의 기본값을 설정
		String boardattachment = oldfile;

		// 파일 파라미터 가져오기
		MultipartFile image = request.getFile("boardattachment");
		
		System.out.println(image.toString());
		// 전송된 파일이 존재하면
		if (image != null && image.isEmpty() == false) {
			// 파일을 저장할 디렉토리 경로 가져오기
			String filePath = request.getRealPath("/img");
			// 새로운 파일명 만들기
			boardattachment = UUID.randomUUID() + image.getOriginalFilename();
			// 실제 파일 경로 만들기
			filePath = filePath + "/" + boardattachment;
			try {
				// 파일을 기록할 출력 스트림 생성
				FileOutputStream fos = new FileOutputStream(filePath);
				// 파일 업로드
				fos.write(image.getBytes());
				fos.close();
			} catch (Exception e) {
				System.out.println("파일 저장 예외:" + e.getMessage());
			}
		}	
		System.out.println("Service(boardattachment): " + boardattachment);

		Boardtbl boardtbl = new Boardtbl();
		boardtbl.setBoardnum(Integer.parseInt(boardnum));
		boardtbl.setBoardtitle(boardtitle);
		boardtbl.setBoardcontent(boardcontent);
		boardtbl.setBoardattachment(boardattachment);
		boardtbl.setBoardwritedate(new Date());
		boardtbl.setMembernickname("광고문의");

		System.out.println("Service: " + boardtbl);
		boardtblDao.update(boardtbl);

		request.setAttribute("update", true); 
	}
	
	
	@Override
	@Transactional
	public void delete(HttpServletRequest request) {
		String boardnum = request.getParameter("boardnum");
		Boardtbl boardtbl = boardtblDao.detail(Integer.parseInt(boardnum));
		System.out.println("Service: " + boardtbl);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("result", false);
		
		boardtblDao.delete(boardtbl);
		map.put("result", true);
		
		request.setAttribute("result", map);
	}
}
