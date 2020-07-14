package gmail.yskim62100.c_and_b_guidebook.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gmail.yskim62100.c_and_b_guidebook.dao.MembertblDao;
import gmail.yskim62100.c_and_b_guidebook.domain.Membertbl;

@Service
public class MembertblServiceImpl implements MembertblService {
	@Autowired
	private MembertblDao membertblDao;

	@Override
	@Transactional
	public void list(HttpServletRequest request, HttpServletResponse response) {
		List<Membertbl> list = membertblDao.list();
		
		request.setAttribute("list", list);
	}

	@Override
	@Transactional
	public void detail(HttpServletRequest request, HttpServletResponse response) {
		String requestURI = request.getRequestURI();
		String [] ar = requestURI.split("/");
		String memberemail = ar[ar.length-1];
		
		System.out.println("memberemail: " + memberemail);
		
		Membertbl membertbl = membertblDao.detail(memberemail);
		
		request.setAttribute("membertbl", membertbl);
		
	}
	
	
}
