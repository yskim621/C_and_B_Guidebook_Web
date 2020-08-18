package gmail.yskim62100.c_and_b_guidebook.service;

import javax.servlet.http.HttpServletRequest;

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
		try {
			
		} catch(Exception e) {
			System.err.println("다운로드 예외: " + e.getMessage());
			e.printStackTrace();
		}

	}

}
