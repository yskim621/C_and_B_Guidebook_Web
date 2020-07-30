package gmail.yskim62100.c_and_b_guidebook.service;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
		
		
		// 결과 저장
		request.setAttribute("boardtbl", boardtbl);
	}
	
	@Override
	@Transactional
	public void insert(HttpServletRequest request, HttpServletResponse response) {
		Boardtbl boardtbl = new Boardtbl();
		try {
			
			String boardtitle = request.getParameter("boardtitle");
			String boardcontent = request.getParameter("boardcontent");
			
			
			// System.out.println("boardtitle:" + boardtitle);
			// System.out.println("boardcontent: " + boardcontent);
		
			boardtbl.setBoardtitle(boardtitle);
			boardtbl.setBoardcontent(boardcontent);
			
			System.out.println("Service1: " + boardtbl);
			
			boardtbl = boardtblDao.insert(boardtbl);
			System.out.println("Service2: " + boardtbl);
			
			request.setAttribute("boardtbl", boardtbl);
			
		} catch(Exception e) {
			System.out.println("Servcie: " + e.getMessage());
			e.printStackTrace();
		}
		 
	}

	@Override
	public void update(HttpServletRequest request, HttpServletResponse response) {
		Boardtbl boardtbl = new Boardtbl();
		try {
			// 요청 주소의 마지막 부분 가져오기
			// localhost/board/update/boardnum
			String requestURI = request.getRequestURI();
			String [] ar = requestURI.split("/");
			String boardnum = ar[ar.length-1];
			
			System.out.println("boardnum: " + boardnum);
			
			String boardtitle = request.getParameter("boardtitle");
			String boardcontent = request.getParameter("boardcontent");
			
			boardtbl.setBoardtitle(boardtitle);
			boardtbl.setBoardcontent(boardcontent);
			
			boardtbl = boardtblDao.update(boardtbl);
			
			request.setAttribute("boardtbl", boardtbl);
		} catch(Exception e) {
			System.out.println("Servcie: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
}
