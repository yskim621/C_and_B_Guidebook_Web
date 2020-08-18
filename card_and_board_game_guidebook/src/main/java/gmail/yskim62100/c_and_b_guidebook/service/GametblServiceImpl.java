package gmail.yskim62100.c_and_b_guidebook.service;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gmail.yskim62100.c_and_b_guidebook.dao.GametblDao;
import gmail.yskim62100.c_and_b_guidebook.domain.Gametbl;

@Service
public class GametblServiceImpl implements GametblService {
	@Autowired
	private GametblDao gametblDao;

	@Override
	@Transactional
	public void gameinfo(HttpServletRequest request) {
		try {
			// 요청 주소의 마지막 부분 가져오기
			// localhost/board/detail/boardnum
			String requestURI = request.getRequestURI();
			String [] ar = requestURI.split("/");
			String gamecode = ar[ar.length-1];
			
			System.out.println("gamecode: " + gamecode);
			
			// DAO 메소드 호출
			Gametbl gametbl = gametblDao.gameinfo(gamecode);
			System.out.println("Service: " + gametbl);
			
			
		} catch(Exception e) {
			System.err.println("다운로드 예외: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
