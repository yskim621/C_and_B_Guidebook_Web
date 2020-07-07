package gmail.yskim62100.c_and_b_guidebook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public void list(HttpServletRequest request, HttpServletResponse response) {
		//1.파라미터 읽기
		
		//2.필요한 처리 수행
				
		//3.DAO 메소드의 매개변수 생성
				
		//4.DAO 메소드를 호출
		List<Boardtbl> list = boardtblDao.list();
		
		//5.결과를 가공
				
		//6.결과를 저장 - REST API Server의 경우는 request에 저장
		request.setAttribute("list", list);	
	}

	@Override
	@Transactional
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		// 요청 주소의 마지막 부분 가져오기
		// localhost/detail/boardtblnum
		String requestURI = request.getRequestURI();
		String [] ar = requestURI.split("/");
		String boardtblnum = ar[ar.length-1];
		
		System.out.println("boardtblnum: " + boardtblnum);
		
		// DAO 메소드 호출
		Boardtbl boardtbl = boardtblDao.detail(Integer.parseInt(boardtblnum));
		
		// 결과 저장
		request.setAttribute("boardtbl", boardtbl);
	}
}
